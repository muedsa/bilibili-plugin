package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UgcSeasonSection(
    @SerialName("season_id") val seasonId: Long = 0L,
    val id: Long = 0L,
    val title: String = "",
    val type: Int = 0,
    val episodes: List<UgcSeasonEpisode>,
)
