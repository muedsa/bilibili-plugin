package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class DynamicModuleDynamicMajor(
    val archive: DynamicMajorArchive,
    val type: String = ""
)