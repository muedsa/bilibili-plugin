package com.muedsa.tvbox.bilibili.helper

import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

@OptIn(ExperimentalStdlibApi::class)
fun hmacSha256(key: String, message: String): String {
    val mac = Mac.getInstance("HmacSHA256")
    val secretKeySpec = SecretKeySpec(key.toByteArray(Charsets.UTF_8), "HmacSHA256")
    mac.init(secretKeySpec)
    val bytes = mac.doFinal(message.toByteArray(Charsets.UTF_8))
    return bytes.toHexString()
}