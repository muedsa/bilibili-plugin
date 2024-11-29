package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class SpaceSearchPage(
    val count: Int = 0,
    val pn: Int = 0,
    val ps: Int = 0,
)
