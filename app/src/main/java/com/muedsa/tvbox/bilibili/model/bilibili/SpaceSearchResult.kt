package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class SpaceSearchResult(
    // episodic_button
    val list: SpaceSearchListInfo = SpaceSearchListInfo(),
    val page: SpaceSearchPage = SpaceSearchPage(),
)
