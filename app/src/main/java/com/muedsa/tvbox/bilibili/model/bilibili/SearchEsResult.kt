package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchEsResult<T>(
    val result: List<T> = emptyList(), // NOTE: 搜索结果可能是Object

    @SerialName("v_voucher") val vVoucher: String? = null,
)
