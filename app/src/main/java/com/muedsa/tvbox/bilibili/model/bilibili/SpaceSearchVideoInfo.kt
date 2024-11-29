package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpaceSearchVideoInfo(
//    val comment: Int = 0,
//    val typeid: Long = 0L,
//    val play: Int = 0,
    val pic: String = "",
    val title: String = "",
    val bvid: String = "",
    val aid: Long = 0L,
    @SerialName("is_charging_arc") val isChargingArc: Boolean = false,
)
