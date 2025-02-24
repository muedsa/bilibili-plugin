package com.muedsa.tvbox.bilibili.model

import com.muedsa.tvbox.bilibili.model.bilibili.SpaceUserInfo
import kotlinx.serialization.Serializable

@Serializable
data class BiliUseSpaceDetailUrlAttrs(
    val mid: Long,
    val page: Int = 1,
    val relation: Int? = null,
    val spaceUserInfo: SpaceUserInfo? = null,
)
