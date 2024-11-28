package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LiveUserRoomInfo(
    val info: LiveUserInfo = LiveUserInfo(),
    // exp
    @SerialName("follower_num") val followerNum: Int = 0,
    @SerialName("room_id") val roomId: Long = 0L,
    @SerialName("medal_name") val medalName: String = "",
    @SerialName("glory_count") val gloryCount: Int = 0,
    val pendant: String = "",
    @SerialName("link_group_num") val linkGroupNum: Int = 0,
    // room_news
)
