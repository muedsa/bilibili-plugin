package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoDescV2(
    @SerialName("raw_text") val rawText: String = "",
    val type: Int = 0,
    @SerialName("biz_id") val bizId: Long = 0L,
)
