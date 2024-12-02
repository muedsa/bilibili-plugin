package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DanmakuInfo(
    val group: String,
    @SerialName("business_id") val businessId: Long,
    // refresh_row_factor
    // refresh_rate
    // max_delay
    val token: String,
    @SerialName("host_list") val hostList: List<DanmakuHost> = emptyList()
)
