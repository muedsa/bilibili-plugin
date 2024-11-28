package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    val type: String = "", // video live_user live_room

    val aid: Long = 0L,
    val bvid: String = "",
    val author: String = "",
    val description: String = "",
    val mid: Long = 0L,
    val pic: String = "",
    val title: String = "",

    val roomid: Long = 0L,
    @SerialName("is_live") val isLive: Boolean = false,
    @SerialName("live_status") val liveStatus: Int = 0,
    @SerialName("live_time") val liveTime: String = "",

    val uid: Long = 0L,
    val uname: String = "",
    val uface: String = "",
) {
    companion object {
        fun removeHitHighlight(text: String): String = text
            .replace("<em class=\"keyword\">", "")
            .replace("</em>", "")

        fun appendProtocol(url: String): String = if (url.startsWith("//")) "https:$url" else url
    }
}
