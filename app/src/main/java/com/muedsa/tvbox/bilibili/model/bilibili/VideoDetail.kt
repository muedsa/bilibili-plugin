package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoDetail(
    val bvid: String,
    val aid: Long,
    val videos: Int,
    val tid: Int,
    val tname: String,
    val copyright: Int = 1,
    val pic: String = "",
    @SerialName("pubdate") val pubDate: Long = 0L,
    val ctime: Long = 0L,
    val desc: String = "",
    @SerialName("desc_v2") val descV2: List<VideoDescV2>? = null,
    val state: Int = 0,
    val duration: Long = 0L,
    // val forward: Long? = null,
    // val mission_id: Long? = null,
    // val redirect_url: String = "",
    // val rights: String = "",
    val owner: SimpleUserInfo? = null,
    val stat: VideoStat,
    val title: String = "",
    // dynamic
    val cid: Long = 0L, // 1P的cid
    // dimension
    @SerialName("season_id") val seasonId: Long? = null,
    @SerialName("is_upower_exclusive") val isUpowerExclusive: Boolean, // 充电专属
    // pages
    val pages: List<VideoPage>,
    @SerialName("ugc_season") val ugcSeason: UgcSeason? = null,
)