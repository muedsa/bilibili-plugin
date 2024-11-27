package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rcmd<T>(
    val item: List<T>,
    val mid: Long = 0L,
    @SerialName("preload_expose_pct") val preloadExposePct: Float = 0.5f,
    @SerialName("preload_floor_expose_pct") val preloadFloorExposePct: Float = 0.5f,
)
