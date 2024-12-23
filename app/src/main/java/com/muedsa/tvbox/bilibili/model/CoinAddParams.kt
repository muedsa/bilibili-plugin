package com.muedsa.tvbox.bilibili.model

import kotlinx.serialization.Serializable

@Serializable
data class CoinAddParams(
    val aid: Long,
    val multiply: Int,
    val selectLike: Int = 1,
    val referer: String,
)