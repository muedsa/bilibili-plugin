package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DynamicModuleAuthor(
    // avatar
    val face: String = "",
    @SerialName("face_nft") val faceNft: Boolean = false,
    val following: Boolean = true,
    @SerialName("jump_url") val jumpUrl: String = "",
    val label: String = "",
    val mid: Long = 0L,
    val name: String = "",
    // official_verify
    // pendant
    @SerialName("pub_action") val pubAction: String = "",
    @SerialName("pub_location_text") val pubLocationText: String = "",
    @SerialName("pub_time") val pubTime: String = "",
    @SerialName("pub_ts") val pubTs: Long = 0L,
    @SerialName("type") val type: String = "",
)
