package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UgcSeasonEpisode(
    @SerialName("season_id") val seasonId: Long = 0L,
    @SerialName("section_id") val sectionId: Long = 0L,
    val id: Long = 0L,
    val aid: Long = 0L,
    val cid: Long = 0L,
    @SerialName("title") val title: String = "",
    // attribute
    // arc
    // page
    val bvid: String = "",
    // pages
)