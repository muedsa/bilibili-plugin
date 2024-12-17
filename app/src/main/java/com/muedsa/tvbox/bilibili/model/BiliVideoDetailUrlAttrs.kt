package com.muedsa.tvbox.bilibili.model

import com.muedsa.tvbox.tool.LenientJson
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString

@Serializable
data class BiliVideoDetailUrlAttrs(
    val bvid: String,
    val page: Int = 1,
    val historyToView: Boolean = false,
) {
    fun toJsonString(): String = LenientJson.encodeToString(this)
}