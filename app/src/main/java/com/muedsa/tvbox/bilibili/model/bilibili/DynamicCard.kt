package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DynamicCard(
    val basic: DynamicBasic,
    @SerialName("id_str") val idStr: String,
    val modules: DynamicModules,
    val type: String = "",
    val visible: Boolean = true,
)
