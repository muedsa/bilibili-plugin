package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataFlow<T>(
    @SerialName("has_more") val hasMore: Boolean = false,
    val items: List<T>,
    val offset: Long,
    @SerialName("update_baseline") val updateBaseline: String = "",
    @SerialName("update_num") val updateNum: Int = 0,
)
