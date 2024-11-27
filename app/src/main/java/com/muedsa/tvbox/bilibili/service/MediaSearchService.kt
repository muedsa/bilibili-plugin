package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.api.data.MediaCardRow
import com.muedsa.tvbox.api.service.IMediaSearchService

class MediaSearchService() : IMediaSearchService {
    override suspend fun searchMedias(query: String): MediaCardRow {
        TODO()
    }
}