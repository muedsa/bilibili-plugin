package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class LiveUserInfo(
    val uid: Long = 0L,
    val uname: String = "",
    val face: String = "",
    // official_verify
    val gender: Int = -1,
)
