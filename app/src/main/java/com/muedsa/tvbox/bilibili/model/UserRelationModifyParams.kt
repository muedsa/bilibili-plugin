package com.muedsa.tvbox.bilibili.model

import kotlinx.serialization.Serializable

@Serializable
data class UserRelationModifyParams(
    val fid: Long,
    val act: Int,
    val referer: String,
)
