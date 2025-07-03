package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayUrlDashTrack(
    val id: Int = 0,
    val baseUrl: String = "",
    val backupUrl: List<String> = emptyList(),
    val bandwidth: Long = 0L,
    val mimeType: String = "",
    val codecs: String = "",
    val width: Int = 0,
    val height: Int = 0,
    val frameRate: String = "",
    val sar: String = "",
    val startWithSap: Int = 0,
    @SerialName("SegmentBase") val segmentBase: DashTrackSegmentBase? = null,
    @SerialName("codecid") val codecId: Int = 0
)
