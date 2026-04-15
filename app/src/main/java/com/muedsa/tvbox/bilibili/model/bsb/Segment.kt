package com.muedsa.tvbox.bilibili.model.bsb

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Segment(
    val cid: Long,
    val category: String,
    val actionType: String,
    val segment: List<Double>,
    @SerialName("UUID") val uuid: String,
    val videoDuration: Double,
    val locked: Int,
    val votes: Int,
    val description: String,
)

