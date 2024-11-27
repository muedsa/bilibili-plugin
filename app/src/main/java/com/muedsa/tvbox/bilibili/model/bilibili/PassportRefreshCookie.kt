package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PassportRefreshCookie(
    val status: Long,
    val message: String = "",
    @SerialName("refresh_token") val refreshToken: String,
)
