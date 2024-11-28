package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class HistoryTab(
    val type: String = "",
    val name: String = "",
)
