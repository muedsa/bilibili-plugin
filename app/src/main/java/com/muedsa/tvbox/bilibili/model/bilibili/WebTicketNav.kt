package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class WebTicketNav(
    val img: String,
    val sub: String,
) {
    val imgKey by lazy { WbiImg.parseKey(img) }
    val subKey by lazy { WbiImg.parseKey(sub) }
}