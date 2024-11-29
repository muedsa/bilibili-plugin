package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.api.data.MediaCard
import com.muedsa.tvbox.api.data.MediaCatalogConfig
import com.muedsa.tvbox.api.data.MediaCatalogOption
import com.muedsa.tvbox.api.data.PagingResult
import com.muedsa.tvbox.api.service.IMediaCatalogService
import com.muedsa.tvbox.api.store.IPluginPerfStore
import com.muedsa.tvbox.bilibili.BILI_WBI_MIXIN_KEY
import com.muedsa.tvbox.bilibili.BilibiliConst
import com.muedsa.tvbox.bilibili.helper.BiliApiHelper
import com.muedsa.tvbox.bilibili.model.BiliVideoDetailUrlAttrs
import com.muedsa.tvbox.bilibili.model.FeedRcmdLoadKey
import com.muedsa.tvbox.tool.LenientJson
import kotlinx.serialization.encodeToString

class MediaCatalogService(
    private val store: IPluginPerfStore,
    private val apiService: BilibiliApiService,
) : IMediaCatalogService {

    override suspend fun getConfig(): MediaCatalogConfig =
        MediaCatalogConfig(
            initKey = LenientJson.encodeToString(FeedRcmdLoadKey()),
            pageSize = 30,
            cardWidth = BilibiliConst.AV_CARD_WIDTH,
            cardHeight = BilibiliConst.AV_CARD_HEIGHT,
        )

    override suspend fun catalog(
        options: List<MediaCatalogOption>,
        loadKey: String,
        loadSize: Int
    ): PagingResult<MediaCard> {
        val key = LenientJson.decodeFromString<FeedRcmdLoadKey>(loadKey)
        var uniqId = key.uniqId ?: BiliApiHelper.generateFixedLengthRandomNumber(12)
        val mixinKey = store.get(BILI_WBI_MIXIN_KEY)
            ?: throw RuntimeException("WBI鉴权参数未获取")
        val resp = apiService.topFeedRcmd(
            BiliApiHelper.buildTopFeedRcmdParams(
                uniqId = uniqId,
                index = key.index,
                lastShowList = key.lastShowList,
                mixinKey = mixinKey
            )
        )
        if (resp.code != 0L) throw RuntimeException(resp.message)
        if (resp.data == null) throw RuntimeException("获取失败")
        val showList = resp.data.item.joinToString(",") { "${it.goto}_${it.id}" }
        val lastShowList = if (key.lastShowList.isEmpty()) showList else "${key.lastShowList},${showList}"
        return PagingResult(
            list = resp.data.item.mapNotNull {
                if (it.goto == "av") {
                    MediaCard(
                        id = it.bvid,
                        detailUrl = BiliVideoDetailUrlAttrs(bvid = it.bvid).toJsonString(),
                        title = it.title,
                        subTitle = it.owner?.name ?: "",
                        coverImageUrl = it.pic
                    )
                } else if (it.goto == "live") {
                    val id = "${MediaDetailService.MEDIA_ID_LIVE_ROOM_PREFIX}${it.id}"
                    MediaCard(
                        id = id,
                        detailUrl = id,
                        title = it.title,
                        subTitle = "[直播]${it.owner?.name ?: ""}",
                        coverImageUrl = it.pic
                    )
                } else null
            },
            nextKey = LenientJson.encodeToString(
                FeedRcmdLoadKey(
                    index = key.index + 1,
                    lastShowList = lastShowList,
                    uniqId = uniqId
                )
            )
        )
    }
}