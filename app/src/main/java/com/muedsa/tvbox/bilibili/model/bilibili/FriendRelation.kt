package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class FriendRelation(
    val mid: Long,
    val attribute: Int,
    val mtime: Long = 0,
    val tag: List<Long>? = null,
    val special: Int = 0,
)
