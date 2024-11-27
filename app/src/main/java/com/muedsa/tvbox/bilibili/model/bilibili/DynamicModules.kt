package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DynamicModules(
    @SerialName("module_author") val moduleAuthor: DynamicModuleAuthor,
    @SerialName("module_dynamic") val moduleDynamic: DynamicModuleDynamic,
    // @SerialName("module_more") val moduleMore: Unit,
    // @SerialName("module_stat") val moduleStat: Unit,
)
