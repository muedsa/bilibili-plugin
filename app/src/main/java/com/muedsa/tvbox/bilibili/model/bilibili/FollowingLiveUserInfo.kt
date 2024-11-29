package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FollowingLiveUserInfo(
    @SerialName("area_id") val areaId: Long = 0L,
    @SerialName("area_name") val areaName: String = "",
    @SerialName("area_name_v2") val areaNameV2: String = "",
    @SerialName("area_value") val areaValue: String = "",
    @SerialName("parent_area_id") val parentAreaId: Long = 0L,
    @SerialName("recent_record_id") val recentRecordId: String = "",
    @SerialName("recent_record_id_v2") val recentRecordIdV2: String = "",
    @SerialName("record_live_time") val recordLiveTime: Long = 0L,
    @SerialName("record_num") val recordNum: Int = 0,
    @SerialName("record_num_v2") val recordNumV2: Int = 0,
    @SerialName("clipnum") val clipNum: Int = 0,
    @SerialName("fans_num") val fansNum: Int = 0,
    @SerialName("is_attention") val isAttention: Int = 0,
    @SerialName("live_status") val liveStatus: Int = 0,
    @SerialName("face") val face: String = "",
    @SerialName("room_cover") val roomCover: String = "",
    @SerialName("room_news") val roomNews: String = "",
    @SerialName("roomid") val roomId: Long = 0L,
    @SerialName("switch") val switch: Boolean = false,
    @SerialName("tags") val tags: String = "",
    @SerialName("text_small") val textSmall: String = "",
    @SerialName("title") val title: String = "",
    @SerialName("uid") val uid: Long = 0L,
    @SerialName("uname") val uname: String = "",
    @SerialName("watch_icon") val watchIcon: String = "",
)
