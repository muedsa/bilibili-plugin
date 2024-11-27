package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PassportQRCodePoll(
    val url: String = "",
    @SerialName("refresh_token") val refreshToken: String = "",
    val timestamp: Long = 0L,
    val code: Long = 0L,
    val message: String = "",
)
