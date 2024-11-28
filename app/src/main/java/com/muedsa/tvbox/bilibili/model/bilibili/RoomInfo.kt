package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoomInfo(
    val uid: Long = 0L,
    @SerialName("room_id") val roomId: Long = 0L,
    @SerialName("short_id") val shortId: Long = 0L,
    val attention: Int = 0,
    val online: Int = 0,
    @SerialName("is_portrait") val isPortrait: Boolean = false,
    val description: String = "",
    @SerialName("live_status") val liveStatus: Int = 0,
    @SerialName("area_id") val areaId: Long = 0L,
    @SerialName("parent_area_id") val parentAreaId: Long = 0L,
    @SerialName("parent_area_name") val parentAreaName: String = "",
    // old_area_id
    val background: String = "",
    val title: String = "",
    @SerialName("user_cover") val userCover: String = "",
    val keyframe: String = "",
    // is_strict_room
    @SerialName("live_time") val liveTime: String = "",
    val tags: String = "",
    // is_anchor
    @SerialName("area_name") val areaName: String = "",
    // more
)
