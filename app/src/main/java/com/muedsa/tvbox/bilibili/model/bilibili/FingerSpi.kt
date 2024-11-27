package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FingerSpi(
    @SerialName("b_3") val b3: String,
    @SerialName("b_4") val b4: String,
)