package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class SimpleUserInfo(
    val mid: Long = 0L,
    val name: String = "",
    val face: String = ""
)