package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class SpaceUserInfo(
    val mid: Long = 0L,
    val name: String = "",
    val sex: String = "",
    val face: String = "",
    // face_nft
    val sign: String? = null
    // more
)