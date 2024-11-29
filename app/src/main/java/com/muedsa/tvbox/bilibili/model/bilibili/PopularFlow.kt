package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularFlow(
    val list: List<PopularVideo> = emptyList(),
    @SerialName("no_more") val noMore: Boolean = true,
)
