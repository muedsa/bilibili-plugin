package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Nav(
    val isLogin: Boolean = false,
    val face: String = "",
    val mid: Long = 0L,
    val uname: String = "",
    @SerialName("wbi_img") val wbiImg: WbiImg,
)
