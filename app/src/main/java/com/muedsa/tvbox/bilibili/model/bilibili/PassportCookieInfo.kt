package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class PassportCookieInfo(
    val refresh: Boolean,
    val timestamp: Long,
)
