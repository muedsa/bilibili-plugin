package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LiveStreamPlayUrlInfo(
    @SerialName("playurl") val playUrl: LiveStreamPlayUrl = LiveStreamPlayUrl()
) {
}