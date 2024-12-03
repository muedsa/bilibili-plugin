package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class LoginExit(
    val redirectUrl: String = ""
)