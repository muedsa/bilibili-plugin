package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoStat(
    val aid: Long = 0L,
    val view: Long = 0L,
    val danmaku: Long = 0L,
    val reply: Long = 0L,
    val favorite: Long = 0L,
    val coin: Long = 0L,
    val share: Long = 0L,
    @SerialName("now_rank") val nowRank: Long = 0L,
    @SerialName("his_rank") val historyRank: Long = 0L,
    val like: Long = 0L,
    @SerialName("dislike") val dislike: Long = 0L,
    val evaluation: String = "",
    val vt: Long = 0L,
)
