package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.bilibili.model.bilibili.BiliResp
import com.muedsa.tvbox.bilibili.model.bilibili.DanmakuInfo
import com.muedsa.tvbox.bilibili.model.bilibili.LivePlayUrl
import com.muedsa.tvbox.bilibili.model.bilibili.LiveUserFollowing
import com.muedsa.tvbox.bilibili.model.bilibili.LiveUserRoomInfo
import com.muedsa.tvbox.bilibili.model.bilibili.RoomInfo
import com.muedsa.tvbox.tool.ChromeUserAgent
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface BilibiliLiveApiService {

    @GET("room/v1/Room/get_info")
    suspend fun getRoomInfo(
        @Query("room_id") roomId: Long,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<RoomInfo>

    @GET("live_user/v1/Master/info")
    suspend fun getLiveUserInfo(
        @Query("uid") uid: Long,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<LiveUserRoomInfo>

    @GET("room/v1/Room/playUrl")
    suspend fun getPlayUrl(
        @Query("cid") cid: Long,
        @Query("platform") platform: String? = null,
        @Query("quality") quality: Int? = 4,
        @Query("qn") qn: Int? = null,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<LivePlayUrl>

//    @GET("xlive/web-ucenter/v1/xfetter/GetWebList")
//    suspend fun xfetterGetWebList(
//        @Query("hit_ad") hitAd: Boolean = false,
//        @Query("_") t: Long = System.currentTimeMillis() / 1000L,
//    )

    @GET("xlive/web-ucenter/user/following")
    suspend fun userFollowing(
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = 9, // max 29
        @Query("ignoreRecord") ignoreRecord: Int = 1,
        @Query("hit_ab") hitAb: Boolean = true,
        @Header("Referer") referer: String = "https://link.bilibili.com/p/center/index",
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<LiveUserFollowing>

    @GET("xlive/web-room/v1/index/getDanmuInfo")
    suspend fun getDanmuInfo(
        @Query("id") id: Long,
        @Query("type") type: Int = 0,
    ): BiliResp<DanmakuInfo>
}