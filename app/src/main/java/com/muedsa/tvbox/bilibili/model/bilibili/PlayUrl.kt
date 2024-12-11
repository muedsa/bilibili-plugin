package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayUrl(
    val from: String = "",
    val result: String = "",
    val message: String = "",
    val quality: Int = 0,
    val format: String = "",
    @SerialName("timelength") val timeLength: Long = 0L,
    @SerialName("accept_format") val acceptFormat: String = "",
    @SerialName("accept_description") val acceptDescription: List<String> = emptyList(),
    @SerialName("accept_quality") val acceptQuality: List<Int> = emptyList(),
    @SerialName("video_codecid") val videoCodecId: Int = 0,
    @SerialName("seek_param") val seekParam: String = "",
    @SerialName("seek_type") val seekType: String = "",
    val dash: PlayUrlDash? = null,
    val durl: List<PlayUrlDurl>? = null,
    @SerialName("support_formats") val supportFormat: List<PlayUrlSupportFormat> = emptyList(),
    // high_format
    @SerialName("last_play_time") val lastPlayTime: Long = 0L,
    @SerialName("last_play_cid") val lastPlayCid: Long = 0L,

    @SerialName("v_voucher") val vVoucher: String? = null, // 被风控 需要人机验证
)