package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.bilibili.model.bilibili.BiliResp
import com.muedsa.tvbox.bilibili.model.bilibili.LivePlayUrl
import com.muedsa.tvbox.bilibili.model.bilibili.LiveUserRoomInfo
import com.muedsa.tvbox.bilibili.model.bilibili.RoomInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface BilibiliLiveApiService {

    @GET("room/v1/Room/get_info")
    suspend fun getRoomInfo(
        @Query("room_id") roomId: Long
    ): BiliResp<RoomInfo>

    @GET("live_user/v1/Master/info")
    suspend fun getLiveUserInfo(
        @Query("uid") uid: Long
    ): BiliResp<LiveUserRoomInfo>

    @GET("room/v1/Room/playUrl")
    suspend fun getPlayUrl(
        @Query("cid") cid: Long,
        @Query("platform") platform: String? = null,
        @Query("quality") quality: Int? = 4,
        @Query("qn") qn: Int? = null,
    ): BiliResp<LivePlayUrl>
}