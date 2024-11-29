package com.muedsa.tvbox.bilibili.service

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
import com.muedsa.tvbox.bilibili.BILI_WBI_MIXIN_KEY
import com.muedsa.tvbox.bilibili.BilibiliConst
import com.muedsa.tvbox.bilibili.helper.BiliApiHelper
import com.muedsa.tvbox.bilibili.helper.BiliCookieHelper
import com.muedsa.tvbox.bilibili.model.BiliVideoDetailUrlAttrs
import com.muedsa.tvbox.bilibili.model.bilibili.LiveUserRoomInfo
import com.muedsa.tvbox.bilibili.model.bilibili.RoomInfo
import com.muedsa.tvbox.bilibili.model.bilibili.VideoDetail
import com.muedsa.tvbox.bilibili.model.bilibili.VideoPage
import com.muedsa.tvbox.tool.ChromeUserAgent
import com.muedsa.tvbox.tool.LenientJson
import com.muedsa.tvbox.tool.SharedCookieSaver
import com.muedsa.tvbox.tool.md5
import kotlinx.serialization.encodeToString
import okhttp3.OkHttpClient
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class MediaDetailService(
    private val store: IPluginPerfStore,
    private val cookieSaver: SharedCookieSaver,
    private val okHttpClient: OkHttpClient,
    passportService: BilibiliPassportService,
    private val apiService: BilibiliApiService,
    private val liveApiService: BilibiliLiveApiService,
) : IMediaDetailService {

    private val actionDelegate = ActionDelegate(
        okHttpClient = okHttpClient,
        passportService = passportService,
        store = store,
    )

    override suspend fun getDetailData(mediaId: String, detailUrl: String): MediaDetail {
        if (mediaId.startsWith(ActionDelegate.ACTION_PREFIX)) {
            return actionDelegate.exec(action = mediaId, data = detailUrl)
        }
        return if (mediaId.startsWith(MEDIA_ID_BV_PREFIX)) {
            val page =
                if (detailUrl.isNotEmpty() && detailUrl.startsWith("{") && detailUrl.endsWith("}")) {
                    val attrs = LenientJson.decodeFromString<BiliVideoDetailUrlAttrs>(detailUrl)
                    attrs.page
                } else 1
            videoDetail(bvid = mediaId, page = page)
        } else if (mediaId.startsWith(MEDIA_ID_LIVE_ROOM_PREFIX)) {
            liveRoomDetail(roomId = mediaId.removePrefix(MEDIA_ID_LIVE_ROOM_PREFIX).toLong())
        } else {
            TODO("暂不支持 $mediaId")
        }
    }

    private suspend fun videoDetail(bvid: String, page: Int = 1): MediaDetail {
        val resp = apiService.wbiView(bvid)
        if (resp.code != 0L || resp.data == null) {
            throw RuntimeException("查询稿件详情失败 ${resp.message}")
        }
        val info = resp.data
        val pageInfo = info.pages.find { it.page == page } ?: info.pages.first()
        val newDetailUrl = LenientJson.encodeToString(
            BiliVideoDetailUrlAttrs(bvid = bvid, page = pageInfo.page)
        )
        val savedDetailUrl = LenientJson.encodeToString(
            BiliVideoDetailUrlAttrs(bvid = bvid, page = 1)
        )
        val rows = mutableListOf<MediaCardRow>()
        if (info.pages.size > 1) {
            rows.add(
                MediaCardRow(
                    title = "视频选集 ($page/${info.pages.size})",
                    list = info.pages.map {
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
                    },
                    cardWidth = BilibiliConst.AV_CARD_WIDTH,
                    cardHeight = BilibiliConst.AV_CARD_HEIGHT,
                )
            )
        }
        info.ugcSeason?.sections?.forEach { section ->
            if (section.episodes.isNotEmpty()) {
                rows.add(
                    MediaCardRow(
                        title = if (info.ugcSeason.sections.size > 1) "${info.ugcSeason.title}-${section.title}" else info.ugcSeason.title,
                        list = section.episodes.map {
                            MediaCard(
                                id = it.bvid,
                                detailUrl = BiliVideoDetailUrlAttrs(
                                    bvid = info.bvid,
                                    page = 1,
                                ).toJsonString(),
                                title = it.title,
                                subTitle = info.owner?.name ?: "",
                                coverImageUrl = info.pic
                            )
                        },
                        cardWidth = BilibiliConst.AV_CARD_WIDTH,
                        cardHeight = BilibiliConst.AV_CARD_HEIGHT,
                    )
                )
            }
        }
        return MediaDetail(
            id = bvid,
            title = info.title,
            subTitle = pageInfo.part,
            description = buildList<String> {
                if (info.isUpowerExclusive) {
                    add("【充电专属】")
                }
                add(info.tname)
                val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                val zoneId = TimeZone.getTimeZone("Asia/Shanghai")
                sdf.timeZone = zoneId
                val date = Date(info.pubDate * 1000L)
                add(sdf.format(date))
                if (info.owner != null) {
                    add(info.owner.name)
                }
            }.joinToString(" | ") + "\n\n${info.desc}",
            detailUrl = newDetailUrl,
            backgroundImageUrl = info.pic,
            playSourceList = listOf(
                MediaPlaySource(
                    id = "bilibili",
                    name = "哔哩哔哩",
                    episodeList = getVideoEpisodeList(info = info, pageInfo = pageInfo)
                )
            ),
            favoritedMediaCard = SavedMediaCard(
                id = bvid,
                title = info.title,
                detailUrl = savedDetailUrl,
                coverImageUrl = info.pic,
                cardWidth = BilibiliConst.AV_CARD_WIDTH,
                cardHeight = BilibiliConst.AV_CARD_HEIGHT,
            ),
            rows = emptyList()
        )
    }

    @OptIn(ExperimentalStdlibApi::class)
    private suspend fun getVideoEpisodeList(info: VideoDetail, pageInfo: VideoPage): List<MediaEpisode> {
        val b3 = BiliCookieHelper.getCookeValue(cookieSaver = cookieSaver, cookieName = BiliCookieHelper.COOKIE_B_3)
        val session = "$b3${System.currentTimeMillis()}".md5().toHexString()
        val resp = apiService.wbiPlayUrl(
            BiliApiHelper.buildWbiPlayUrlParams(
                bvid = info.bvid,
                cid = pageInfo.cid,
                session = session,
                mixinKey = store.get(BILI_WBI_MIXIN_KEY)
                    ?: throw RuntimeException("WBI鉴权参数未获取")
            ),
            referer = "${BilibiliConst.MAIN_SITE_URL}/video/${info.bvid}/?spm_id_from=333.1007.tianma.1-1-1.click"
        )
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
        return resp.data.dash.video.map { videoTrack ->
            val qualityName =
                resp.data.supportFormat.find { it.quality == videoTrack.id }?.newDescription ?: "??"
            MediaEpisode(
                id = "${info.bvid}_${pageInfo.cid}",
                name = "$qualityName(${videoTrack.codecs})",
                flag3 = pageInfo.cid,
                flag5 = info.bvid,
                flag6 = videoTrack.baseUrl,
                flag7 =  resp.data.dash.audio.firstOrNull()?.baseUrl,
            )
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
        return MediaDetail(
            id = savedId,
            title = liveUserRoomInfo.info.uname,
            subTitle = roomInfo.title,
            description = buildList<String> {
                add("\uD83D\uDD25 ${roomInfo.online}")
                add("❤ ${roomInfo.attention}")
                add("${roomInfo.parentAreaName}/${roomInfo.areaName}")
                if (roomInfo.liveTime.isNotBlank()) {
                    add(roomInfo.liveTime)
                }
            }.joinToString(" | ") + "\n\n${roomInfo.description}",
            detailUrl = savedId,
            backgroundImageUrl = roomInfo.keyframe,
            playSourceList = createLiveRoomPlaySource(roomInfo = roomInfo),
            favoritedMediaCard = SavedMediaCard(
                id = savedId,
                title = liveUserRoomInfo.info.uname,
                detailUrl = savedId,
                coverImageUrl = if (roomInfo.userCover.isNotBlank()) roomInfo.userCover else roomInfo.keyframe,
                cardWidth = BilibiliConst.AV_CARD_WIDTH,
                cardHeight = BilibiliConst.AV_CARD_HEIGHT,
            ),
            rows = emptyList()
        )
    }

    private suspend fun createLiveRoomPlaySource(roomInfo: RoomInfo): List<MediaPlaySource> {
        return if (roomInfo.liveStatus == 1) {
            val resp = liveApiService.getPlayUrl(
                cid = roomInfo.roomId,
                platform = "android",
                quality = 4,
            )
            if (resp.code == 0L && resp.data != null) {
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
                        episodeList = resp.data!!.durl.mapIndexed { index, durl ->
                            MediaEpisode(
                                id = "$MEDIA_ID_LIVE_ROOM_PREFIX${roomInfo.roomId}",
                                name = if (resp.message.isNotBlank()) resp.message else "获取直播地址失败",
                            )
                        }
                    )
                )
            }
        } else emptyList()
    }

    override suspend fun getEpisodePlayInfo(
        playSource: MediaPlaySource,
        episode: MediaEpisode
    ): MediaHttpSource {
        return if (episode.id.startsWith(MEDIA_ID_BV_PREFIX)) {
            return getVideoEpisodePlayInfo(episode = episode)
        } else if (episode.id.startsWith(MEDIA_ID_LIVE_ROOM_PREFIX)) {
            return getLiveEpisodePlayInfo(episode = episode)
        } else {
            TODO("暂不支持的类型 ${episode.id}")
        }
    }

    private fun getVideoEpisodePlayInfo(episode: MediaEpisode): MediaHttpSource {
        val bvid =  episode.flag5?: throw RuntimeException("flag5 is empty")
        val videoUrl = episode.flag6?: throw RuntimeException("flag6 is empty")
        val audioUrl = episode.flag7
        val headers =  mapOf(
            "User-Agent" to ChromeUserAgent,
            "Referer" to "${BilibiliConst.MAIN_SITE_URL}/video/$bvid/?spm_id_from=333.1007.tianma.1-1-1.click",
        )
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

    companion object {
        const val MEDIA_ID_BV_PREFIX = "BV"
        const val MEDIA_ID_LIVE_ROOM_PREFIX = "LIVE_ROOM:"
        val V_VOUCHER_MEDIA_EPISODE_LIST = listOf(
            MediaEpisode(
                id = " MEDIA_EPISODE_V_VOUCHER",
                name = "获取播放地址被风控, 需要人机验证",
            )
        )
    }
}