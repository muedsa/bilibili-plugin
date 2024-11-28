package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.api.data.MediaCard
import com.muedsa.tvbox.api.data.MediaCatalogConfig
import com.muedsa.tvbox.api.data.MediaCatalogOption
import com.muedsa.tvbox.api.data.PagingResult
import com.muedsa.tvbox.api.service.IMediaCatalogService
import com.muedsa.tvbox.bilibili.BilibiliConst

class MediaCatalogService(
) : IMediaCatalogService {

    override suspend fun getConfig(): MediaCatalogConfig =
        MediaCatalogConfig(
            initKey = "1",
            pageSize = 1,
            cardWidth = BilibiliConst.AV_CARD_WIDTH,
            cardHeight = BilibiliConst.AV_CARD_HEIGHT,
        )

    override suspend fun catalog(
        options: List<MediaCatalogOption>,
        loadKey: String,
        loadSize: Int
    ): PagingResult<MediaCard> = PagingResult()
}