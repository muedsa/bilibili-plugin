package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class HistoryCursorFlow(
    val cursor: HistoryCursor,
    val tab: List<HistoryTab> = emptyList(),
    val list: List<History> = emptyList(),
)
