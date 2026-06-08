package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LiveStream(
    @SerialName("protocol_name") val protocolName: String = "",
    val format: List<LiveStreamFormat> = emptyList(),
)
