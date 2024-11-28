package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayUrlSupportFormat(
    val quality: Int = 0,
    val format: String = "",
    @SerialName("new_description") val newDescription: String = "",
    val superscript: String = "",
    val codecs: List<String>? = null
)
