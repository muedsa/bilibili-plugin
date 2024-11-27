package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class BiliResp<T>(
    val code: Long = 0L,
    val message: String = "",
    val data: T? = null,
    val ttl: Long = 0L,
)