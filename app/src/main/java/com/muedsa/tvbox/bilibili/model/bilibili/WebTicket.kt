package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WebTicket(
    val ticket: String,
    @SerialName("created_at") val createdAt: Long,
    val ttl: Long,
    // val context: Unit = Unit,
    val nav: WebTicketNav,
)
