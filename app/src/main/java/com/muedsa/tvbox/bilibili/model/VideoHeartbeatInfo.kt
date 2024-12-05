package com.muedsa.tvbox.bilibili.model

import kotlinx.serialization.Serializable

@Serializable
data class VideoHeartbeatInfo(
    val aid: Long,
    val cid: Long,
    val videoDuration: Long,
    val type: Int = 3,
    val subType: Int = 0,
    val quality: Int,
)
