package com.muedsa.tvbox.bilibili.model

import kotlinx.serialization.Serializable

@Serializable
data class HistoryToViewModifyParams(
    val bvid: String,
    val aid: Long,
)
