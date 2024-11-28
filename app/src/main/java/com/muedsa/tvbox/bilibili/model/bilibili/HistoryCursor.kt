package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HistoryCursor(
    val max: Long = 0L,
    @SerialName("view_at") val viewAt: Long = 0L,
    val business: String = "",
    val ps: Int = 0,
)
