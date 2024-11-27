package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class PlayUrlDash(
    val duration: Long = 0L,
    val minBufferTime: Float = 0f,
    val video: List<PlayUrlDashTrack> = emptyList(),
    val audio: List<PlayUrlDashTrack> = emptyList(),
    // dolby
    // flac
)