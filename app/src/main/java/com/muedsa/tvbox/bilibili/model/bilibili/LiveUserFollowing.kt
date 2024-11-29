package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LiveUserFollowing(
    @SerialName("title") val title: String = "",
    @SerialName("pageSize") val pageSize: Int = 0,
    @SerialName("totalPage") val totalPage: Int = 0,
    @SerialName("list") val list: List<FollowingLiveUserInfo> = emptyList(),
    @SerialName("count") val count: Int = 0,
    @SerialName("live_count") val liveCount: Int = 0,
    @SerialName("never_lived_count") val neverLivedCount: Int = 0,
    // never_lived_faces
)