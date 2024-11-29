package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularVideo(
    val aid: Long = 0L,
    val bvid: String = "",
    val cid: Long = 0L,
    val pic: String = "",
    @SerialName("pubdate") val pubDate: Long = 0L,
    val ctime: Long = 0L,
    val desc: String = "",
    @SerialName("first_frame") val firstFrame: String = "",
    val owner: SimpleUserInfo? = SimpleUserInfo(),
    val tid: Long = 0,
    val tname: String = "",
    val title: String = "",
)
