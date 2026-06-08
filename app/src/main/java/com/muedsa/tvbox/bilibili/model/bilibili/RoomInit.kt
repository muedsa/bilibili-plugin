package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoomInit(
    @SerialName("room_id") val roomId: Long,
    @SerialName("short_id") val shortId: Long,
    val uid: Long = 0,
    @SerialName("playurl_info") val playUrlInfo: LiveStreamPlayUrlInfo = LiveStreamPlayUrlInfo()
)