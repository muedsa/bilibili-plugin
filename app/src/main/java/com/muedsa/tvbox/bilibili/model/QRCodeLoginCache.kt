package com.muedsa.tvbox.bilibili.model

import kotlinx.serialization.Serializable

@Serializable
data class QRCodeLoginCache(
    val url: String,
    val key: String,
    val flag: Int = 0
)