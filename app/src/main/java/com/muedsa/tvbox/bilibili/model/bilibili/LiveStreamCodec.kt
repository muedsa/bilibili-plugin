package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LiveStreamCodec(
    @SerialName("codec_name") val codecName: String = "",
    @SerialName("current_qn") val currentQn: Int = 0,
    @SerialName("accept_qn") val acceptQn: List<Int> = emptyList(),
    @SerialName("base_url") val baseUrl: String = "",
    @SerialName("url_info") val urlInfo: List<LiveStreamCodecUrlInfo> = emptyList(),
    val session: String = "",
)
