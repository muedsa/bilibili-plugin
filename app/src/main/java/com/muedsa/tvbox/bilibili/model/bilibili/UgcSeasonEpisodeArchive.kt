package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class UgcSeasonEpisodeArchive(
    val aid: Long = 0,
    val pic: String = "",
    val title: String = "",
)