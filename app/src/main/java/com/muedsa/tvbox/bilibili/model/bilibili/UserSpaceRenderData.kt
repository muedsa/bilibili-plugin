package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserSpaceRenderData(
    @SerialName("access_id") val accessId: String = ""
)
