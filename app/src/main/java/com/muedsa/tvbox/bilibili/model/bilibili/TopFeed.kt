package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopFeed(
    val id: Long, // roomid 或 aid
    val bvid: String,
    val cid: Long,
    val goto: String, // av: 视频 ogv: 边栏 live: 直播
    val uri: String = "",
    val pic: String = "",
    @SerialName("pic_4_3") val pic43: String = "",
    val title: String = "",
    val duration: Long = 0L, // 秒
    val pubdate: Long = 0L,
    @SerialName("is_followed") val isFollowed: Int = 0, // 0: 未关注 1: 已关注
    val owner: SimpleUserInfo? = null,
    val stat: VideoStat? = null,
)
