package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DanmakuHost(
    val host: String,
    val port: Int,
    @SerialName("wss_port") val wssPort: Int,
    @SerialName("ws_port") val wsPort: Int,
)
