package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LivePlayUrlDurl(
    val url: String = "",
    val length: Long = 0L,
    val order: Int = 0,
    @SerialName("stream_type") val streamType: Int = 0,
    @SerialName("p2p_type") val p2pType: Int = 0,
)
