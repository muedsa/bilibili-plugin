package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DynamicMajorArchive(
    val aid: String = "",
    // badge
    val bvid: String = "",
    val cover: String = "",
    val desc: String = "",
    @SerialName("disable_preview") val disablePreview: Int = 0,
    @SerialName("duration_text") val durationText: String = "",
    @SerialName("jump_url") val jumpUrl: String = "",
    // stat
    val title: String = "",
    val type: Int = 0,
)