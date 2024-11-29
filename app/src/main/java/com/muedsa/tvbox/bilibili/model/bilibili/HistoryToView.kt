package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class HistoryToView(
    val count: Int = 0,
    val list: List<HistoryToViewVideo> = emptyList(),
)
