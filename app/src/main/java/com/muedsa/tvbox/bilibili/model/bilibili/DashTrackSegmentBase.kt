package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DashTrackSegmentBase(
    @SerialName("Initialization") val initialization: String = "",
    @SerialName("indexRange") val indexRange: String = "",
)
