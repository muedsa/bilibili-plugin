package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DynamicBasic(
    @SerialName("comment_id_str") val commentIdStr: String,
    @SerialName("comment_type") val commentType: Int,
    @SerialName("rid_str") val ridStr: String,
)
