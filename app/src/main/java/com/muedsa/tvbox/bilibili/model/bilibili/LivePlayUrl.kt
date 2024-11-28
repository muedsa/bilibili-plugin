package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LivePlayUrl(
    @SerialName("current_quality") val currentQuality: Int = 0,
    @SerialName("accept_quality") val acceptQuality: List<String> = emptyList(),
    @SerialName("current_qn") val currentQn: Int = 0,
    @SerialName("accept_qn") val acceptQn: List<LivePlayQn> = emptyList(),
    val durl: List<LivePlayUrlDurl> = emptyList(),
)
