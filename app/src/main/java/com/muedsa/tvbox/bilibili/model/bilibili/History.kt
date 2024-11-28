package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class History(
    @SerialName("author_face") val authorFace: String = "",
    @SerialName("author_mid") val authorMid: Long = 0L,
    @SerialName("author_name") val authorName: String = "",
    val badge: String = "",
    val cover: String = "",
    // @SerialName("covers") val covers: List<String>? = null,
    val current: String = "",
    val duration: Long = 0L,
    val history: HistoryInfo,
    @SerialName("is_fav") val isFav: Int = 0,
    @SerialName("is_finish") val isFinish: Int = 0,
    val kid: Long = 0L,
    @SerialName("live_status") val liveStatus: Int = 0,
    @SerialName("long_title") val longTitle: String = "",
    @SerialName("new_desc") val newDesc: String = "",
   val progress: Long = 0L,
    @SerialName("show_title") val showTitle: String = "",
    @SerialName("tag_name") val tagName: String = "",
    val title: String = "",
    val total: Int = 0,
    val uri: String = "",
    val videos: Int = 0,
    @SerialName("view_at") val viewAt: Long = 0L,
)
