package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class HistoryToViewVideo(
    val aid: Long = 0L,
    val bvid: String = "",
    val cid: Long = 0L,
    val owner: SimpleUserInfo? = null,
    val pic: String = "",
    val title: String = "",
    val tname: String = "",
)
