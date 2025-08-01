package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.api.data.DanmakuData
import com.muedsa.tvbox.api.data.DanmakuDataFlow
import com.muedsa.tvbox.api.data.MediaCard
import com.muedsa.tvbox.api.data.MediaCardRow
import com.muedsa.tvbox.api.data.MediaDetail
import com.muedsa.tvbox.api.data.MediaEpisode
import com.muedsa.tvbox.api.data.MediaHttpSource
import com.muedsa.tvbox.api.data.MediaMergingHttpSource
import com.muedsa.tvbox.api.data.MediaPlaySource
import com.muedsa.tvbox.api.data.SavedMediaCard
import com.muedsa.tvbox.api.service.IMediaDetailService
import com.muedsa.tvbox.api.store.IPluginPerfStore
import com.muedsa.tvbox.bilibili.BILI_VIDEO_HEARTBEAT
import com.muedsa.tvbox.bilibili.BILI_WBI_MIXIN_KEY
import com.muedsa.tvbox.bilibili.BilibiliConst
import com.muedsa.tvbox.bilibili.helper.BiliApiHelper
import com.muedsa.tvbox.bilibili.helper.BiliCookieHelper
import com.muedsa.tvbox.bilibili.model.BiliUseSpaceDetailUrlAttrs
import com.muedsa.tvbox.bilibili.model.BiliVideoDetailUrlAttrs
import com.muedsa.tvbox.bilibili.model.CoinAddParams
import com.muedsa.tvbox.bilibili.model.HistoryToViewModifyParams
import com.muedsa.tvbox.bilibili.model.PagedMediaCardRows
import com.muedsa.tvbox.bilibili.model.UserRelationModifyParams
import com.muedsa.tvbox.bilibili.model.VideoHeartbeatInfo
import com.muedsa.tvbox.bilibili.model.bilibili.BiliResp
import com.muedsa.tvbox.bilibili.model.bilibili.LiveUserRoomInfo
import com.muedsa.tvbox.bilibili.model.bilibili.PlayUrl
import com.muedsa.tvbox.bilibili.model.bilibili.RoomInfo
import com.muedsa.tvbox.bilibili.model.bilibili.VideoDetail
import com.muedsa.tvbox.bilibili.model.bilibili.VideoPage
import com.muedsa.tvbox.tool.ChromeUserAgent
import com.muedsa.tvbox.tool.LenientJson
import com.muedsa.tvbox.tool.SharedCookieSaver
import com.muedsa.tvbox.tool.feignChrome
import com.muedsa.tvbox.tool.get
import com.muedsa.tvbox.tool.md5
import com.muedsa.tvbox.tool.parseHtml
import com.muedsa.tvbox.tool.toRequestBuild
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import okhttp3.OkHttpClient
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import kotlin.math.ceil

class MediaDetailService(
    private val store: IPluginPerfStore,
    private val cookieSaver: SharedCookieSaver,
    private val okHttpClient: OkHttpClient,
    passportService: BilibiliPassportService,
    private val apiService: BilibiliApiService,
    private val liveApiService: BilibiliLiveApiService,
    private val apiGrpcService: BilibiliApiGrpcService,
    private val debug: Boolean = false,
) : IMediaDetailService {

    private val actionDelegate = ActionDelegate(
        okHttpClient = okHttpClient,
        passportService = passportService,
        apiService = apiService,
        store = store,
        cookieSaver = cookieSaver,
    )

    override suspend fun getDetailData(mediaId: String, detailUrl: String): MediaDetail {
        return if (mediaId.startsWith(ActionDelegate.ACTION_PREFIX)) {
            actionDelegate.exec(action = mediaId, data = detailUrl)
        } else if (mediaId.startsWith(MEDIA_ID_BV_PREFIX)) {
            videoDetail(attrs = LenientJson.decodeFromString<BiliVideoDetailUrlAttrs>(detailUrl))
        } else if (mediaId.startsWith(MEDIA_ID_LIVE_ROOM_PREFIX)) {
            liveRoomDetail(roomId = mediaId.removePrefix(MEDIA_ID_LIVE_ROOM_PREFIX).toLong())
        } else if (mediaId.startsWith(MEDIA_ID_USER_SPACE_PREFIX)) {
            userSpaceDetail(
                attrs = if (detailUrl.startsWith(MEDIA_ID_USER_SPACE_PREFIX)) {
                    BiliUseSpaceDetailUrlAttrs(
                        mid = mediaId.removePrefix(MEDIA_ID_USER_SPACE_PREFIX).toLong(),
                        page = 1,
                    )
                } else {
                    LenientJson.decodeFromString<BiliUseSpaceDetailUrlAttrs>(
                        detailUrl
                    )
                }
            )
        } else {
            TODO("暂不支持 $mediaId")
        }
    }

    private suspend fun videoDetail(
        attrs: BiliVideoDetailUrlAttrs
    ): MediaDetail {
        val referer =
            "${BilibiliConst.MAIN_SITE_URL}/video/${attrs.bvid}/?spm_id_from=333.1007.tianma.1-1-1.click"
        val resp = apiService.wbiView(attrs.bvid)
        if (resp.code != 0L || resp.data == null) {
            throw RuntimeException("查询稿件详情失败 ${resp.message}")
        }
        val info = resp.data
        val pageInfo = info.pages.find { it.page == attrs.page } ?: info.pages.first()
        val newDetailUrl = LenientJson.encodeToString(
            BiliVideoDetailUrlAttrs(bvid = attrs.bvid, page = pageInfo.page)
        )
        val savedDetailUrl = LenientJson.encodeToString(
            BiliVideoDetailUrlAttrs(bvid = attrs.bvid, page = 1)
        )
        val rows = mutableListOf<MediaCardRow>()
        if (info.pages.size > 1) {
            info.pages
                .map {
                    MediaCard(
                        id = info.bvid,
                        detailUrl = BiliVideoDetailUrlAttrs(
                            bvid = info.bvid,
                            page = it.page,
                        ).toJsonString(),
                        title = "${it.part} ${info.title}",
                        subTitle = info.owner?.name ?: "",
                        coverImageUrl = info.pic
                    )
                }
                .chunked(20)
                .mapIndexed { index, item ->
                    MediaCardRow(
                        title = if (index == 0) "视频选集 (${attrs.page}/${info.pages.size})" else "",
                        list = item,
                        cardWidth = BilibiliConst.AV_CARD_WIDTH,
                        cardHeight = BilibiliConst.AV_CARD_HEIGHT,
                    )
                }
                .let { rows.addAll(it) }
        }
        info.ugcSeason?.sections?.forEach { section ->
            if (section.episodes.isNotEmpty()) {
                section.episodes
                    .map {
                        MediaCard(
                            id = it.bvid,
                            detailUrl = BiliVideoDetailUrlAttrs(
                                bvid = it.bvid,
                                page = 1,
                            ).toJsonString(),
                            title = it.title,
                            subTitle = info.owner?.name ?: "",
                            coverImageUrl = it.arc.pic,
                        )
                    }
                    .chunked(20)
                    .mapIndexed { index, item ->
                        MediaCardRow(
                            title = if (index == 0) {
                                if (info.ugcSeason.sections.size > 1)
                                    "${info.ugcSeason.title}-${section.title}"
                                else info.ugcSeason.title
                            } else "",
                            list = item,
                            cardWidth = BilibiliConst.AV_CARD_WIDTH,
                            cardHeight = BilibiliConst.AV_CARD_HEIGHT,
                        )
                    }
                    .let { rows.addAll(it) }
            }
        }
        if (info.owner?.mid != null && info.owner.mid > 0) {
            val userSpaceId = "$MEDIA_ID_USER_SPACE_PREFIX${info.owner.mid}"
            rows.add(
                MediaCardRow(
                    title = "其他",
                    list = listOf(
                        MediaCard(
                            id = userSpaceId,
                            title = "投稿视频",
                            subTitle = info.owner.name,
                            detailUrl = LenientJson.encodeToString(
                                BiliUseSpaceDetailUrlAttrs(
                                    mid = info.owner.mid,
                                    page = 1,
                                )
                            ),
                            coverImageUrl = info.owner.face
                        )
                    ),
                    cardWidth = BilibiliConst.AVATAR_CARD_WIDTH,
                    cardHeight = BilibiliConst.AVATAR_CARD_HEIGHT
                )
            )
        }
        return MediaDetail(
            id = info.bvid,
            title = info.title,
            subTitle = pageInfo.part,
            description = buildList<String> {
                if (info.isUpowerExclusive) {
                    add("【充电专属】")
                }
                add(info.tname)
                if (info.owner != null) {
                    add(info.owner.name)
                }
                val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                val zoneId = TimeZone.getTimeZone("Asia/Shanghai")
                sdf.timeZone = zoneId
                val date = Date(info.pubDate * 1000L)
                add(sdf.format(date))
            }.joinToString(" | ") + "\n\n${info.desc}",
            detailUrl = newDetailUrl,
            backgroundImageUrl = info.pic,
            playSourceList = listOf(
                MediaPlaySource(
                    id = "bilibili",
                    name = "哔哩哔哩",
                    episodeList = getVideoEpisodeList(info = info, pageInfo = pageInfo)
                        .toMutableList()
                        .apply {
                            addAll(
                                index = if (isNotEmpty()) 1 else 0,
                                listOf(
                                    MediaEpisode(
                                        id = ActionDelegate.ACTION_COIN_ADD,
                                        name = "投币+2 & 点赞",
                                        flag5 = LenientJson.encodeToString(
                                            CoinAddParams(
                                                aid = info.aid,
                                                multiply = 2,
                                                referer = referer,
                                            )
                                        ),
                                    ),
                                    MediaEpisode(
                                        id = ActionDelegate.ACTION_COIN_ADD,
                                        name = "投币+1 & 点赞",
                                        flag5 = LenientJson.encodeToString(
                                            CoinAddParams(
                                                aid = info.aid,
                                                multiply = 1,
                                                referer = referer,
                                            )
                                        ),
                                    ),
                                    MediaEpisode(
                                        id = if (attrs.historyToView) ActionDelegate.ACTION_HISTORY_TO_VIEW_DEL else ActionDelegate.ACTION_HISTORY_TO_VIEW_ADD,
                                        name = if (attrs.historyToView) "从稍后再看中移除" else "添加至稍后再看",
                                        flag5 = LenientJson.encodeToString(
                                            HistoryToViewModifyParams(
                                                bvid = info.bvid,
                                                aid = info.aid,
                                            )
                                        ),
                                    ),
                                )
                            )
                        }
                )
            ),
            favoritedMediaCard = SavedMediaCard(
                id = info.bvid,
                title = info.title,
                detailUrl = savedDetailUrl,
                subTitle = info.owner?.name,
                coverImageUrl = info.pic,
                cardWidth = BilibiliConst.AV_CARD_WIDTH,
                cardHeight = BilibiliConst.AV_CARD_HEIGHT,
            ),
            rows = rows,
            enableCustomDanmakuList = true,
        )
    }

    @OptIn(ExperimentalStdlibApi::class)
    private suspend fun getVideoEpisodeList(info: VideoDetail, pageInfo: VideoPage): List<MediaEpisode> {
        //var resp: BiliResp<PlayUrl>? = null
        val url = "${BilibiliConst.MAIN_SITE_URL}/video/${info.bvid}/?spm_id_from=333.1007.tianma.1-1-1.click"
        val head = url.toRequestBuild()
            .feignChrome(referer = "${BilibiliConst.MAIN_SITE_URL}/")
            .get(okHttpClient = okHttpClient)
            .parseHtml()
            .head()
        val headHtml = head.html()
        var playUrlJson = PLAY_URL_REGEX.find(headHtml)?.groups[1]?.value
        if (playUrlJson.isNullOrEmpty()) {
            PLAY_URL_SSR_DATA_REGEX.find(headHtml)?.groups[1]?.value?.let {
                playUrlJson = LenientJson.parseToJsonElement(it)
                    .jsonObject["result"]
                    ?.jsonObject["video_info"]
                    ?.let {
                        if (it is JsonObject) {
                            """{"code": 0, "data": $it}"""
                        } else null
                    }
            }
        }
        Timber.d("playUrlFromHtml=$playUrlJson")
        val resp: BiliResp<PlayUrl> = if (playUrlJson.isNullOrEmpty() || pageInfo.page > 1) {
            // 尝试从SSR页面获取失败, 从接口请求获取
            val b3 = BiliCookieHelper.getCookeValue(cookieSaver = cookieSaver, cookieName = BiliCookieHelper.COOKIE_B_3)
            val session = "$b3${System.currentTimeMillis()}".md5().toHexString()
            apiService.wbiPlayUrl(
                BiliApiHelper.buildWbiPlayUrlParams(
                    aid = info.aid,
                    bvid = info.bvid,
                    cid = pageInfo.cid,
                    session = session,
                    mixinKey = store.get(BILI_WBI_MIXIN_KEY)
                        ?: throw RuntimeException("WBI鉴权参数未获取")
                ),
                referer = url
            )
        } else {
            LenientJson.decodeFromString<BiliResp<PlayUrl>>(playUrlJson)
        }
        if (resp.code != 0L || resp.data == null) {
            return listOf(
                MediaEpisode(
                    id = " MEDIA_EPISODE_ERROR",
                    name = "获取失败: ${resp.message}",
                )
            )
        }
        if (!resp.data.vVoucher.isNullOrEmpty()) {
            return V_VOUCHER_MEDIA_EPISODE_LIST
        }
        return if (resp.data.dash != null) {
            resp.data.dash.video.map { videoTrack ->
                val qualityName =
                    resp.data.supportFormat.find { it.quality == videoTrack.id }?.newDescription
                        ?: "??"
                MediaEpisode(
                    id = "${info.bvid}_${pageInfo.cid}",
                    name = "$qualityName(${videoTrack.codecs})",
                    flag1 = ceil(resp.data.timeLength / 360000.0).toInt(),
                    flag3 = pageInfo.cid,
                    flag4 = info.aid,
                    flag5 = info.bvid,
                    flag6 = videoTrack.baseUrl,
                    flag7 = resp.data.dash.audio.firstOrNull()?.baseUrl,
                    flag8 = LenientJson.encodeToString(
                        VideoHeartbeatInfo(
                            aid = info.aid,
                            cid = info.cid,
                            videoDuration = (resp.data.timeLength / 1000),
                            quality = videoTrack.id
                        )
                    )
                )
            }
        } else if (!resp.data.durl.isNullOrEmpty()) {
            val qualityName =
                resp.data.supportFormat.find { it.quality == resp.data.quality }?.newDescription
                    ?: "??"
            listOf(
                MediaEpisode(
                    id = "${info.bvid}_${pageInfo.cid}",
                    name = qualityName,
                    flag1 = ceil(resp.data.timeLength / 360000.0).toInt(),
                    flag3 = pageInfo.cid,
                    flag4 = info.aid,
                    flag5 = info.bvid,
                    flag6 = resp.data.durl.first().url,
                    flag8 = LenientJson.encodeToString(
                        VideoHeartbeatInfo(
                            aid = info.aid,
                            cid = info.cid,
                            videoDuration = (resp.data.timeLength / 1000),
                            quality = resp.data.quality
                        )
                    )
                )
            )
        } else {
            V_VOUCHER_MEDIA_EPISODE_LIST
        }
    }

    private suspend fun liveRoomDetail(roomId: Long? = null, uid: Long? = null): MediaDetail {
        var roomInfo: RoomInfo
        var liveUserRoomInfo: LiveUserRoomInfo
        if (roomId != null) {
            val roomInfoResp = liveApiService.getRoomInfo(roomId = roomId)
            if (roomInfoResp.code != 0L || roomInfoResp.data == null) {
                throw RuntimeException("获取直播间信息失败 ${roomInfoResp.message}")
            }
            roomInfo = roomInfoResp.data
            val liveUserInfoResp = liveApiService.getLiveUserInfo(uid = roomInfo.uid)
            if (liveUserInfoResp.code != 0L || liveUserInfoResp.data == null) {
                throw RuntimeException("获取直播间信息失败 ${liveUserInfoResp.message}")
            }
            liveUserRoomInfo = liveUserInfoResp.data
        } else if (uid != null) {
            val liveUserInfoResp = liveApiService.getLiveUserInfo(uid = uid)
            if (liveUserInfoResp.code != 0L || liveUserInfoResp.data == null) {
                throw RuntimeException("获取直播间信息失败 ${liveUserInfoResp.message}")
            }
            liveUserRoomInfo = liveUserInfoResp.data
            val roomInfoResp = liveApiService.getRoomInfo(roomId = liveUserRoomInfo.roomId)
            if (roomInfoResp.code != 0L || roomInfoResp.data == null) {
                throw RuntimeException("获取直播间信息失败 ${roomInfoResp.message}")
            }
            roomInfo = roomInfoResp.data
        } else {
            throw RuntimeException("roomId或uid至少有一个不能为空")
        }
        val savedId = "$MEDIA_ID_LIVE_ROOM_PREFIX$roomId"
        val userSpaceId = "$MEDIA_ID_USER_SPACE_PREFIX${roomInfo.uid}"
        return MediaDetail(
            id = savedId,
            title = liveUserRoomInfo.info.uname,
            subTitle = roomInfo.title,
            description = buildList<String> {
                add("\uD83D\uDD25 ${roomInfo.online}")
                add("❤ ${roomInfo.attention}")
                add("${roomInfo.parentAreaName}/${roomInfo.areaName}")
                if (roomInfo.liveTime.isNotBlank()) {
                    if (roomInfo.liveStatus == 1) {
                        add("开播时间: ${roomInfo.liveTime}")
                    } else {
                        add("未开播")
                    }
                }
            }.joinToString(" | ") + "\n\n${roomInfo.description}",
            detailUrl = savedId,
            backgroundImageUrl = roomInfo.keyframe.ifBlank { roomInfo.userCover },
            playSourceList = createLiveRoomPlaySource(roomInfo = roomInfo),
            favoritedMediaCard = SavedMediaCard(
                id = savedId,
                title = roomInfo.title,
                subTitle = "[直播]${liveUserRoomInfo.info.uname}",
                detailUrl = savedId,
                coverImageUrl = roomInfo.userCover.ifBlank { roomInfo.keyframe },
                cardWidth = BilibiliConst.AV_CARD_WIDTH,
                cardHeight = BilibiliConst.AV_CARD_HEIGHT,
            ),
            rows = listOf(
                MediaCardRow(
                    title = "其他",
                    list = listOf(
                        MediaCard(
                            id = userSpaceId,
                            title = "投稿视频",
                            subTitle = liveUserRoomInfo.info.uname,
                            detailUrl = LenientJson.encodeToString(
                                BiliUseSpaceDetailUrlAttrs(
                                    mid = roomInfo.uid,
                                    page = 1,
                                )
                            ),
                            coverImageUrl = liveUserRoomInfo.info.face,
                        )
                    ),
                    cardWidth = BilibiliConst.AVATAR_CARD_WIDTH,
                    cardHeight = BilibiliConst.AVATAR_CARD_HEIGHT,
                )
            ),
            disableEpisodeProgression = true,
            enableCustomDanmakuFlow = true,
        )
    }

    private suspend fun createLiveRoomPlaySource(roomInfo: RoomInfo): List<MediaPlaySource> {
        return if (roomInfo.liveStatus == 1) {
            val resp = liveApiService.getPlayUrl(
                cid = roomInfo.roomId,
                platform = "android",
                quality = 4,
            )
            if (resp.code == 0L && resp.data?.durl != null) {
                listOf(
                    MediaPlaySource(
                        id = "bilibili_live",
                        name = "哔哩哔哩直播",
                        episodeList = resp.data.durl.mapIndexed { index, durl ->
                            MediaEpisode(
                                id = "$MEDIA_ID_LIVE_ROOM_PREFIX${roomInfo.roomId}",
                                name = "线路${index + 1}",
                                flag3 = roomInfo.roomId,
                                flag5 = durl.url,
                            )
                        }
                    )
                )
            } else {
                listOf(
                    MediaPlaySource(
                        id = "bilibili_live",
                        name = "哔哩哔哩直播",
                        episodeList = listOf(
                            MediaEpisode(
                                id = "$MEDIA_ID_LIVE_ROOM_PREFIX${roomInfo.roomId}",
                                name = resp.message.ifBlank { "获取直播地址失败" },
                            )
                        )
                    )
                )
            }
        } else emptyList()
    }

    private suspend fun userSpaceDetail(attrs: BiliUseSpaceDetailUrlAttrs): MediaDetail {
        val mixinKey = store.get(BILI_WBI_MIXIN_KEY)
            ?: throw RuntimeException("WBI鉴权参数未获取")
        val referer = "${BilibiliConst.SPACE_URL}/${attrs.mid}/upload/video"
        var spaceUserInfo = attrs.spaceUserInfo
        var relation = attrs.relation
        if (spaceUserInfo == null) {
            val userInfoResp = apiService.spaceWbiAccInfo(
                params = BiliApiHelper.buildWbiAccInfoParams(
                    mid = attrs.mid,
                    mixinKey = mixinKey,
                ),
                referer = referer
            )
            if (userInfoResp.code != 0L) throw RuntimeException(userInfoResp.message)
            if (userInfoResp.data == null) throw RuntimeException("获取UP信息失败")
            spaceUserInfo = userInfoResp.data
        }
        if (relation == null) {
            val relationResp = apiService.relation(
                params = BiliApiHelper.buildRelationParams(
                    fid = attrs.mid,
                    mixinKey = mixinKey,
                ),
                referer = referer,
            )
            relation = relationResp.data?.attribute
        }

        val savedId = "$MEDIA_ID_USER_SPACE_PREFIX${attrs.mid}"
        return MediaDetail(
            id = savedId,
            title = spaceUserInfo.name,
            subTitle = null,
            description = spaceUserInfo.sign,
            detailUrl = savedId,
            backgroundImageUrl = spaceUserInfo.face,
            playSourceList = buildList {
                if (relation == 0) {
                    add(
                        MediaPlaySource(
                            id = "action",
                            name = "操作",
                            episodeList = listOf(
                                MediaEpisode(
                                    id = ActionDelegate.ACTION_USER_FOLLOW,
                                    name = "关注",
                                    flag5 = LenientJson.encodeToString(
                                        UserRelationModifyParams(
                                            fid = spaceUserInfo.mid,
                                            act = 1,
                                            referer = referer,
                                        )
                                    ),
                                )
                            )
                        )
                    )
                }
            },
            favoritedMediaCard = SavedMediaCard(
                id = savedId,
                title = "[投稿]${spaceUserInfo.name}",
                detailUrl = LenientJson.encodeToString(
                    BiliUseSpaceDetailUrlAttrs(
                        mid = spaceUserInfo.mid,
                        page = 1,
                    )
                ),
                subTitle = "投稿视频",
                coverImageUrl = spaceUserInfo.face,
                cardWidth = BilibiliConst.AV_CARD_WIDTH,
                cardHeight = BilibiliConst.AV_CARD_HEIGHT,
            ),
            rows = buildList {
                val pagedMediaCardRows = getUserSpaceVideoRow(
                    mid = spaceUserInfo.mid,
                    mixinKey = mixinKey,
                    referer = referer,
                    appPage = attrs.page,
                )
                addAll(pagedMediaCardRows.rows)
                if (pagedMediaCardRows.totalPage > attrs.page) {
                    add(
                        MediaCardRow(
                            title = "操作",
                            list = listOf(
                                MediaCard(
                                    id = savedId,
                                    title = "更多投稿视频",
                                    subTitle = spaceUserInfo.name,
                                    detailUrl = LenientJson.encodeToString(
                                        BiliUseSpaceDetailUrlAttrs(
                                            mid = spaceUserInfo.mid,
                                            page = attrs.page + 1,
                                        )
                                    ),
                                    coverImageUrl = spaceUserInfo.face,
                                )
                            ),
                            cardWidth = BilibiliConst.AVATAR_CARD_WIDTH,
                            cardHeight = BilibiliConst.AVATAR_CARD_WIDTH,
                        )
                    )
                }
            },
            disableEpisodeProgression = true
        )
    }

    private suspend fun getUserSpaceVideoRow(
        mid: Long,
        mixinKey: String,
        referer: String,
        appPage: Int = 1,
    ): PagedMediaCardRows {
        val rows = mutableListOf<MediaCardRow>()
        var page = ((appPage - 1) * USER_SPACE_VIDEO_ROW_COUNT) + 1
        val maxPage = page + USER_SPACE_VIDEO_ROW_COUNT
        var count = 0
        while (page < maxPage) {
            val params = BiliApiHelper.buildWbiArcSearchParams(
                page = page,
                pageSize = USER_SPACE_VIDEO_ROW_SIZE,
                mid = mid,
                mixinKey = mixinKey
            )
            val resp = apiService.spaceWbiArcSearch(params = params, referer = referer)
            if (resp.code != 0L) break
            if (resp.data == null) break
            if (resp.data.list.vlist.isEmpty()) break
            rows.add(
                MediaCardRow(
                    title = "投稿视频-第${page}页",
                    list = resp.data.list.vlist.map {
                        MediaCard(
                            id = it.bvid,
                            detailUrl = BiliVideoDetailUrlAttrs(
                                bvid = it.bvid,
                                page = 1,
                            ).toJsonString(),
                            title = it.title,
                            subTitle = if (it.isChargingArc) "充电专属" else "",
                            coverImageUrl = it.pic
                        )
                    },
                    cardWidth = BilibiliConst.AV_CARD_WIDTH,
                    cardHeight = BilibiliConst.AV_CARD_HEIGHT,
                )
            )
            count = resp.data.page.count
            if (page * USER_SPACE_VIDEO_ROW_SIZE > resp.data.page.count) break
            page++
        }
        return PagedMediaCardRows(
            count = count,
            totalPage = ceil(count * 1.0 / (USER_SPACE_VIDEO_ROW_SIZE * USER_SPACE_VIDEO_ROW_COUNT)).toInt(),
            rows = rows,
        )
    }

    override suspend fun getEpisodePlayInfo(
        playSource: MediaPlaySource,
        episode: MediaEpisode
    ): MediaHttpSource {
        return if (episode.id.startsWith(ActionDelegate.ACTION_PREFIX)) {
            actionDelegate.execAsGetEpisodePlayInfo(action = episode.id, data = episode.flag5)
        } else if (episode.id.startsWith(MEDIA_ID_BV_PREFIX)) {
            getVideoEpisodePlayInfo(episode = episode)
        } else if (episode.id.startsWith(MEDIA_ID_LIVE_ROOM_PREFIX)) {
            getLiveEpisodePlayInfo(episode = episode)
        } else {
            TODO("暂不支持的类型 ${episode.id}")
        }
    }

    private suspend fun getVideoEpisodePlayInfo(episode: MediaEpisode): MediaHttpSource {
        val bvid =  episode.flag5?: throw RuntimeException("flag5 is empty")
        val videoUrl = episode.flag6?: throw RuntimeException("flag6 is empty")
        val audioUrl = episode.flag7
        val headers =  mapOf(
            "User-Agent" to ChromeUserAgent,
            "Referer" to "${BilibiliConst.MAIN_SITE_URL}/video/$bvid/?spm_id_from=333.1007.tianma.1-1-1.click",
        )
        val csrf = BiliCookieHelper.getCookeValue(
            cookieSaver = cookieSaver,
            cookieName = BiliCookieHelper.COOKIE_B_JCT
        )
        val midStr = BiliCookieHelper.getCookeValue(
            cookieSaver = cookieSaver,
            cookieName = BiliCookieHelper.COOKIE_UID
        )
        if (csrf != null && midStr != null && episode.flag8 != null) {
            val heartbeat = store.getOrDefault(BILI_VIDEO_HEARTBEAT, 0)
            if (heartbeat == 1 || heartbeat == 2) {
                val mid = midStr.toLong()
                val startTs = System.currentTimeMillis() / 1000
                val videoHeartbeatInfo =
                    LenientJson.decodeFromString<VideoHeartbeatInfo>(episode.flag8!!)
                val time = if (heartbeat == 1) 1 else videoHeartbeatInfo.videoDuration
                val params = BiliApiHelper.buildWebHeartbeatParams(
                    startTs = startTs,
                    mid = mid,
                    aid = videoHeartbeatInfo.aid,
                    realTime = time,
                    playedTime = time,
                    realPlayedTime = time,
                    videoDuration = videoHeartbeatInfo.videoDuration,
                    lastPlayProgressTime = time,
                    mixinKey = store.get(BILI_WBI_MIXIN_KEY)
                        ?: throw RuntimeException("WBI鉴权参数未获取")
                )
                apiService.webHeartbeat(
                    params = params,
                    startTs = startTs,
                    mid = mid,
                    aid = videoHeartbeatInfo.aid,
                    cid = videoHeartbeatInfo.cid,
                    playedTime = if (heartbeat == 1) time else -1,
                    realTime = time,
                    realPlayedTime = time,
                    lastPlayProgressTime = time,
                    maxPlayProgressTime = time,
                    quality = videoHeartbeatInfo.quality,
                    videoDuration = videoHeartbeatInfo.videoDuration,
                    type = videoHeartbeatInfo.type,
                    subType = videoHeartbeatInfo.subType,
                    playType = if (heartbeat == 1) 1 else 4,
                    csrf = csrf,
                )
            }
        }
        return if (audioUrl.isNullOrEmpty()) {
            MediaHttpSource(url = videoUrl, httpHeaders = headers)
        } else {
            MediaMergingHttpSource(urls = listOf(videoUrl, audioUrl), httpHeaders = headers)
        }
    }

    private fun getLiveEpisodePlayInfo(episode: MediaEpisode): MediaHttpSource {
        // val roomId = episode.id.removePrefix(MEDIA_ID_LIVE_ROOM_PREFIX)
        val url = episode.flag5 ?: throw RuntimeException("获取直播地址失败")
        return MediaHttpSource(url = url)
    }

    override suspend fun getEpisodeDanmakuDataList(episode: MediaEpisode): List<DanmakuData> {
        return if (
            episode.id.startsWith(MEDIA_ID_BV_PREFIX)
            && episode.flag1 != null
            && episode.flag3 != null
        ) {
            val mixinKey = store.get(BILI_WBI_MIXIN_KEY) ?: throw RuntimeException("WBI鉴权参数未获取")
            val maxIndex = episode.flag1!!
            var index = 0
            val list = mutableListOf<DanmakuData>()
            while (index < maxIndex) {
                val dmSegMobileReply = apiGrpcService.dmWbiWebSegSo(
                    BiliApiHelper.buildDmWbiWebSegSoParams(
                        oid = episode.flag3!!,
                        segmentIndex = index + 1,
                        mixinKey = mixinKey,
                    )
                )
                list.addAll(
                    dmSegMobileReply.elemsList.mapNotNull {
                        val model: Int? = when(it.mode) {
                            1,2,3 -> 1
                            4 -> 4
                            5 -> 5
                            else -> null
                        }
                        if (model != null) {
                            DanmakuData(
                                danmakuId = it.id,
                                position = it.progress.toLong(),
                                content = it.content,
                                textColor = it.color,
                                mode = model,
                                score = it.weight
                            )
                        } else null
                    }
                )
                index++
            }
            list
        } else emptyList()
    }

    override suspend fun getEpisodeDanmakuDataFlow(episode: MediaEpisode): DanmakuDataFlow? {
        return if (episode.id.startsWith(MEDIA_ID_LIVE_ROOM_PREFIX)) {
            val mixinKey = store.get(BILI_WBI_MIXIN_KEY) ?: return null
            val roomId = episode.flag3 ?: throw RuntimeException("")
            val resp = liveApiService.getDanmuInfo(
                params = BiliApiHelper.buildGetDanmuInfoParams(
                    id = roomId,
                    mixinKey = mixinKey,
                ),
            )
            if (resp.code != 0L || resp.data == null) {
                Timber.e("获取直播间弹幕TOKEN失败: $resp")
                null
            } else {
                val hostInfo = resp.data.hostList.first()
                LiveDanmakuDataFlow(
                    uid = BiliCookieHelper.getCookeValue(
                        cookieSaver = cookieSaver,
                        cookieName = BiliCookieHelper.COOKIE_UID,
                        defaultValue = "0",
                    )!!.toLong(),
                    roomId = roomId,
                    b3 = BiliCookieHelper.getCookeValue(
                        cookieSaver = cookieSaver,
                        cookieName = BiliCookieHelper.COOKIE_B_3,
                        defaultValue = "",
                    )!!,
                    token = resp.data.token,
                    request = "wss://${hostInfo.host}:${hostInfo.wssPort}/sub"
                        .toRequestBuild()
                        .header("User-Agent", ChromeUserAgent)
                        .build(),
                    okHttpClient = okHttpClient,
                    debug = debug,
                )
            }
        } else null
    }

    companion object {
        const val MEDIA_ID_BV_PREFIX = "BV"
        const val MEDIA_ID_LIVE_ROOM_PREFIX = "LIVE_ROOM:"
        const val MEDIA_ID_USER_SPACE_PREFIX = "USER_SPACE:"
        val V_VOUCHER_MEDIA_EPISODE_LIST = listOf(
            MediaEpisode(
                id = " MEDIA_EPISODE_V_VOUCHER",
                name = "获取播放地址被风控, 需要人机验证",
            )
        )
        const val USER_SPACE_VIDEO_ROW_SIZE = 42
        const val USER_SPACE_VIDEO_ROW_COUNT = 10
        val PLAY_URL_REGEX = "<script>window\\.__playinfo__=(\\{.*?\\})</script>".toRegex()
        val PLAY_URL_SSR_DATA_REGEX = "const playurlSSRData = (\\{.*?\\}\n)".toRegex()
    }
}