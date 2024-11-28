package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class LivePlayQn(
    val qn: Int = 0,
    val desc: String = "",
)
