package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.bilibili.helper.hmacSha256
import com.muedsa.tvbox.bilibili.model.bilibili.BiliResp
import com.muedsa.tvbox.bilibili.model.bilibili.DataFlow
import com.muedsa.tvbox.bilibili.model.bilibili.DynamicCard
import com.muedsa.tvbox.bilibili.model.bilibili.FingerSpi
import com.muedsa.tvbox.bilibili.model.bilibili.HistoryCursorFlow
import com.muedsa.tvbox.bilibili.model.bilibili.Nav
import com.muedsa.tvbox.bilibili.model.bilibili.PlayUrl
import com.muedsa.tvbox.bilibili.model.bilibili.Rcmd
import com.muedsa.tvbox.bilibili.model.bilibili.SearchEsResult
import com.muedsa.tvbox.bilibili.model.bilibili.SearchResult
import com.muedsa.tvbox.bilibili.model.bilibili.TopFeed
import com.muedsa.tvbox.bilibili.model.bilibili.VideoDetail
import com.muedsa.tvbox.bilibili.model.bilibili.WebTicket
import com.muedsa.tvbox.tool.ChromeUserAgent
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface BilibiliApiService {

    @GET("x/web-interface/nav")
    suspend fun nav(@Header("User-Agent") userAgent: String = ChromeUserAgent): BiliResp<Nav>

    @POST("bapis/bilibili.api.ticket.v1.Ticket/GenWebTicket")
    suspend fun genWebTicket(
        @Query("key_id") keyId: String = "ec02",
        @Query("context[ts]") ts: Long = System.currentTimeMillis() / 1000,
        @Query("hexsign") hexSign: String = hmacSha256("XgwSnGZ1p", "ts${ts}"),
        @Query("csrf") csrf: String? = null,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<WebTicket>

    @GET("x/frontend/finger/spi")
    suspend fun fingerSpi(
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<FingerSpi>

    @GET("x/web-interface/wbi/index/top/feed/rcmd")
    suspend fun topFeedRcmd(
        @QueryMap params: Map<String, String>,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<Rcmd<TopFeed>>

    @GET("x/polymer/web-dynamic/v1/feed/all")
    suspend fun dynamicFeedAll(
        @Query("timezone_offset") timezoneOffset: Long = -480,
        @Query("type") type: String = "video",
        @Query("platform") platform: String = "web",
        @Query("host_mid") hostMid: Long? = null,
        @Query("page") page: Int = 1,
        @Query("offset") offset: Long? = null,
        @Query("features") features: String = "itemOpusStyle,listOnlyfans,opusBigCover,onlyfansVote,decorationCard,onlyfansAssetsV2,forwardListHidden,ugcDelete,onlyfansQaCard,commentsNewVersion",
        @Query("web_location") webLocation: String = "333.1365",
        @Query("x-bili-device-req-json") xBiliDeviceReqJson: String = "{\"platform\":\"web\",\"device\":\"pc\"}",
        @Query("x-bili-web-req-json") xBiliWebReqJson: String = "{\"spm_id\":\"333.1365\"}",
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<DataFlow<DynamicCard>>

    @GET("x/web-interface/wbi/view")
    suspend fun wbiView(
        @Query("bvid") bvid: String,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<VideoDetail>

    @GET("x/player/wbi/playurl")
    suspend fun wbiPlayUrl(
        @QueryMap params: Map<String, String>,
        @Header("Referer") referer: String,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ) : BiliResp<PlayUrl>

    @GET("x/web-interface/history/cursor")
    suspend fun historyCursor(
        @Query("max") max: Long? = null,
        @Query("business") business: String? = null,
        @Query("view_at") viewAt: Long? = 0,
        @Query("type") type: String? = null,
        @Query("ps") ps: Int? = 30,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ) : BiliResp<HistoryCursorFlow>

    @GET("x/web-interface/wbi/search/type")
    suspend fun wbiSearchType(
        @QueryMap params: Map<String, String>,
        @Header("Referer") referer: String = "https://search.bilibili.com/",
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ) : BiliResp<SearchEsResult<SearchResult>>
}