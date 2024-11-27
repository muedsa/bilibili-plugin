package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UgcSeason(
    val id: Long = 0L,
    val title: String = "",
    val cover: String = "",
    val mid: Long = 0L,
    val intro: String = "",
    val sections: List<UgcSeasonSection>,
    // stat
    @SerialName("ep_count") val epCount: Int = 0,
    @SerialName("season_type") val seasonType: Int = 0,
    @SerialName("is_pay_season") val isPaySeason: Boolean = false,
    // enable_vt
)
