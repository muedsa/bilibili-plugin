package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.bilibili.BilibiliConst
import com.muedsa.tvbox.bilibili.model.bilibili.BiliResp
import com.muedsa.tvbox.bilibili.model.bilibili.DanmakuInfo
import com.muedsa.tvbox.bilibili.model.bilibili.LivePlayUrl
import com.muedsa.tvbox.bilibili.model.bilibili.LiveUserFollowing
import com.muedsa.tvbox.bilibili.model.bilibili.LiveUserRoomInfo
import com.muedsa.tvbox.bilibili.model.bilibili.RoomInfo
import com.muedsa.tvbox.bilibili.model.bilibili.RoomPlayInfo
import com.muedsa.tvbox.tool.ChromeUserAgent
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.http.QueryMap

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
        @Header("Referer") referer: String = "${BilibiliConst.LINK_URL}/p/center/index",
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<LiveUserFollowing>

    @GET("xlive/web-room/v1/index/getDanmuInfo")
    suspend fun getDanmuInfo(
        @QueryMap params: Map<String, String>,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<DanmakuInfo>

    @GET("xlive/web-room/v2/index/getRoomPlayInfo")
    suspend fun getRoomPlayInfo(
        @Query("room_id") cid: Long,
        @Query("protocol") protocol: String = "0,1",
        @Query("format") format: String = "0,1,2",
        @Query("codec") codec: String = "0,1",
        @Query("qn") qn: Int = 0,
        @Query("platform") platform: String = "web",
        @Query("ptype") ptype: Int = 8,
        @Query("dolby") dolby: Int = 5,
        @Query("panoramic") panoramic: Int = 1,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<RoomPlayInfo>
}