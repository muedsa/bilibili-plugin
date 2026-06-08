package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LiveStreamFormat(
    @SerialName("format_name") val formatName: String = "",
    val codec: List<LiveStreamCodec> = emptyList(),
)
