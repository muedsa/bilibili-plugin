package com.muedsa.tvbox.bilibili.model

import com.muedsa.tvbox.api.data.MediaCardRow

data class PagedMediaCardRows(
    val count: Int = 0,
    val totalPage: Int = 0,
    val rows: List<MediaCardRow> = emptyList(),
)
