package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.api.data.MediaCard
import com.muedsa.tvbox.api.data.MediaCardRow
import com.muedsa.tvbox.api.service.IMediaSearchService
import com.muedsa.tvbox.api.store.IPluginPerfStore
import com.muedsa.tvbox.bilibili.BILI_WBI_MIXIN_KEY
import com.muedsa.tvbox.bilibili.BilibiliConst
import com.muedsa.tvbox.bilibili.helper.BiliApiHelper
import com.muedsa.tvbox.bilibili.model.BiliVideoDetailUrlAttrs
import com.muedsa.tvbox.bilibili.model.bilibili.BiliResp
import com.muedsa.tvbox.bilibili.model.bilibili.SearchEsResult
import com.muedsa.tvbox.bilibili.model.bilibili.SearchResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class MediaSearchService(
    private val store: IPluginPerfStore,
    private val apiService: BilibiliApiService
) : IMediaSearchService {

    override suspend fun searchMedias(query: String): MediaCardRow {
        val mixinKey = store.get(BILI_WBI_MIXIN_KEY)
            ?: throw RuntimeException("WBI鉴权参数未获取")
        val (resp1, resp2) = coroutineScope {
            listOf(
                // live_user
                async(Dispatchers.IO) {
                    apiService.wbiSearchType(
                        BiliApiHelper.buildSearchParams(
                            keyword = query,
                            searchType = "live_user",
                            mixinKey = mixinKey
                        )
                    )
                },
                // video
                async(Dispatchers.IO) {
                    apiService.wbiSearchType(
                        BiliApiHelper.buildSearchParams(
                            keyword = query,
                            searchType = "video",
                            mixinKey = mixinKey
                        )
                    )
                },
            ).awaitAll()
        }
        checkRespError(resp1)
        checkRespError(resp2)
        return MediaCardRow(
            title = "search",
            list = listOf(resp1.data?.result ?: emptyList(), resp2.data?.result ?: emptyList())
                .flatMap { it }
                .mapNotNull {
                    if (it.type == "video") {
                        MediaCard(
                            id = it.bvid,
                            detailUrl = BiliVideoDetailUrlAttrs(bvid = it.bvid).toJsonString(),
                            title = SearchResult.removeHitHighlight(it.title),
                            subTitle = SearchResult.removeHitHighlight(it.author),
                            coverImageUrl = SearchResult.appendProtocol(it.pic)
                        )
                    } else if (it.type == "live_user") {
                        MediaCard(
                            id = "${MediaDetailService.MEDIA_ID_LIVE_ROOM_PREFIX}${it.roomid}",
                            detailUrl = "${MediaDetailService.MEDIA_ID_LIVE_ROOM_PREFIX}${it.roomid}",
                            title = SearchResult.removeHitHighlight(it.uname),
                            subTitle = if (it.isLive) "直播中" else "未开播",
                            coverImageUrl = SearchResult.appendProtocol(it.uface)
                        )
                    } else null
                },
            cardWidth = BilibiliConst.AV_CARD_WIDTH,
            cardHeight = BilibiliConst.AV_CARD_HEIGHT,
        )
    }

    private fun checkRespError(resp: BiliResp<SearchEsResult<SearchResult>>) {
        if (resp.code != 0L) {
            throw RuntimeException("请求搜索失败:${resp.message}")
        }
        if (resp.data?.vVoucher?.isNotBlank() == true) {
            throw RuntimeException("请求搜索被风控, 需要人机验证")
        }
    }
}