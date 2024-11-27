package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PassportQRCode(
    val url: String,
    @SerialName("qrcode_key") val qrcodeKey: String,
)
