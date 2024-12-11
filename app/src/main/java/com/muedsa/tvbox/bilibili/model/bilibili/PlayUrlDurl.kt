package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayUrlDurl(
    val order: Int = 0,
    val length: Long = 0L,
    val size: Long = 0L,
    val ahead: String = "",
    val vhead: String = "",
    val url: String = "",
    @SerialName("backup_url") val backupUrl: List<String>? = null,
)
