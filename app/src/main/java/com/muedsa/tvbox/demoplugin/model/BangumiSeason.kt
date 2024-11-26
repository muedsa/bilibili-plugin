package com.muedsa.tvbox.demoplugin.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BangumiSeason (
    @SerialName("year") val year: Int,
    @SerialName("month") val month: Int,
    @SerialName("seasonName") val seasonName: String
)