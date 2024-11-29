package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class SpaceSearchListInfo(
    // slist
    // tlist
    val vlist: List<SpaceSearchVideoInfo> = emptyList(),
)
