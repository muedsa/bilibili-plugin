package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LiveStreamPlayUrl(
    val cid: Long = 0,
    @SerialName("g_qn_desc") val gQnDesc: List<LivePlayQn> = emptyList(),
    val stream: List<LiveStream> = emptyList(),
)
