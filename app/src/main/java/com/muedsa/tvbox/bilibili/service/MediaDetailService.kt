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
import com.muedsa.tvbox.bilibili.model.bilibili.BiliResp
import com.muedsa.tvbox.bilibili.model.bilibili.PlayUrl
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
    private val apiService: BilibiliApiService
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
            TODO("暂不支持直播")
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
                if (info.owner != null) {
                    add("UP: ${info.owner.name}")
                }
                add("分类: ${info.tname}")
                val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
                val zoneId = TimeZone.getTimeZone("Asia/Shanghai")
                sdf.timeZone = zoneId
                val date = Date(info.pubDate * 1000L)
                add("发布时间: ${sdf.format(date)}")
                add("简介: ${info.desc}")
            }.joinToString("\n"),
            detailUrl = newDetailUrl,
            backgroundImageUrl = info.pic,
            playSourceList = listOf(
                MediaPlaySource(
                    id = "bilibili",
                    name = "哔哩哔哩",
                    episodeList = getEpisodeList(info = info, pageInfo = pageInfo)
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

    private fun getEpisodeList(info: VideoDetail, pageInfo: VideoPage): List<MediaEpisode> {
        val url = "${BilibiliConst.MAIN_SITE_URL}/video/${info.bvid}/?spm_id_from=333.1007.tianma.1-1-1.click"
        val head = url.toRequestBuild()
            .feignChrome(referer = "${BilibiliConst.MAIN_SITE_URL}/")
            .get(okHttpClient = okHttpClient)
            .parseHtml()
            .head()
        val playUrlJson = PLAY_URL_REGEX.find(head.html())?.groups[1]?.value
        if (playUrlJson.isNullOrEmpty()) {
            return V_VOUCHER_MEDIA_EPISODE_LIST
        }
        val resp = LenientJson.decodeFromString<BiliResp<PlayUrl>>(playUrlJson)
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
                id = "${pageInfo.cid}_${videoTrack.id}_${videoTrack.codecs}",
                name = "$qualityName(${videoTrack.codecs})",
                flag3 = pageInfo.cid,
                flag5 = info.bvid,
                flag6 = videoTrack.baseUrl,
                flag7 = resp.data.dash.audio.firstOrNull()?.baseUrl,
            )
        }
    }

    @OptIn(ExperimentalStdlibApi::class)
    private suspend fun getEpisodeList_bak(info: VideoDetail, pageInfo: VideoPage): List<MediaEpisode> {
        val b3 = BiliCookieHelper.getCookeValue(cookieSaver = cookieSaver, cookieName = "buvid3")
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
                id = "${pageInfo.cid}",
                name = "$qualityName(${videoTrack.codecs})",
                flag3 = pageInfo.cid,
                flag5 = info.bvid,
                flag6 = videoTrack.baseUrl,
                flag7 =  resp.data.dash.audio.firstOrNull()?.baseUrl,
            )
        }
    }

    override suspend fun getEpisodePlayInfo(
        playSource: MediaPlaySource,
        episode: MediaEpisode
    ): MediaHttpSource {
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

    companion object {
        const val MEDIA_ID_BV_PREFIX = "BV"
        const val MEDIA_ID_LIVE_ROOM_PREFIX = "LIVE_ROOM:"
        val V_VOUCHER_MEDIA_EPISODE_LIST = listOf(
            MediaEpisode(
                id = " MEDIA_EPISODE_V_VOUCHER",
                name = "获取播放地址被风控, 需要人机验证",
            )
        )

        val PLAY_URL_REGEX = "<script>window\\.__playinfo__=(\\{.*?\\})</script>".toRegex()
    }
}