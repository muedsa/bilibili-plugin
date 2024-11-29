package com.muedsa.tvbox.bilibili.model

import kotlinx.serialization.Serializable

@Serializable
data class FeedRcmdLoadKey(
    val index: Int = 1,
    val lastShowList: String = "",
    val uniqId: String? = null,
)
