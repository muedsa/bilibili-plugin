package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class LivePageSsrData(
    val roomInitRes: BiliResp<RoomInit>? = null
) {
}