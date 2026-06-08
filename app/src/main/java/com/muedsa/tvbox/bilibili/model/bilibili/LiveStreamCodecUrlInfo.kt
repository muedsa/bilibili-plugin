package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LiveStreamCodecUrlInfo(
    val host: String = "",
    val extra: String = "",
    @SerialName("stream_ttl") val streamTTL: Int = 0,
)
