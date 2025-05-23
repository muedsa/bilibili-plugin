package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.bilibili.BilibiliConst
import com.muedsa.tvbox.bilibili.helper.hmacSha256
import com.muedsa.tvbox.bilibili.model.bilibili.BiliResp
import com.muedsa.tvbox.bilibili.model.bilibili.CoinAdd
import com.muedsa.tvbox.bilibili.model.bilibili.DataFlow
import com.muedsa.tvbox.bilibili.model.bilibili.DynamicCard
import com.muedsa.tvbox.bilibili.model.bilibili.FingerSpi
import com.muedsa.tvbox.bilibili.model.bilibili.FriendRelation
import com.muedsa.tvbox.bilibili.model.bilibili.HistoryCursorFlow
import com.muedsa.tvbox.bilibili.model.bilibili.HistoryToView
import com.muedsa.tvbox.bilibili.model.bilibili.Nav
import com.muedsa.tvbox.bilibili.model.bilibili.PlayUrl
import com.muedsa.tvbox.bilibili.model.bilibili.PopularFlow
import com.muedsa.tvbox.bilibili.model.bilibili.Rcmd
import com.muedsa.tvbox.bilibili.model.bilibili.SearchEsResult
import com.muedsa.tvbox.bilibili.model.bilibili.SearchResult
import com.muedsa.tvbox.bilibili.model.bilibili.SpaceSearchResult
import com.muedsa.tvbox.bilibili.model.bilibili.SpaceUserInfo
import com.muedsa.tvbox.bilibili.model.bilibili.TopFeed
import com.muedsa.tvbox.bilibili.model.bilibili.VideoDetail
import com.muedsa.tvbox.bilibili.model.bilibili.WebTicket
import com.muedsa.tvbox.tool.ChromeUserAgent
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

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
        @Header("Referer") referer: String = "${BilibiliConst.SEARCH_URL}/",
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ) : BiliResp<SearchEsResult<SearchResult>>

    @GET("x/web-interface/popular")
    suspend fun popular(
        @QueryMap params: Map<String, String>,
        @Header("Referer") referer: String = "${BilibiliConst.MAIN_SITE_URL}/v/popular/all/?spm_id_from=333.1007.0.0",
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ) : BiliResp<PopularFlow>

    @GET("x/space/wbi/acc/info")
    suspend fun spaceWbiAccInfo(
        @QueryMap params: Map<String, String>,
        @Header("Referer") referer: String,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<SpaceUserInfo>

    @GET("x/space/wbi/arc/search")
    suspend fun spaceWbiArcSearch(
        @QueryMap params: Map<String, String>,
        @Header("Referer") referer: String,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ) : BiliResp<SpaceSearchResult>

    @GET("x/v2/history/toview/web")
    suspend fun historyToViewWeb(
        @Query("web_location") webLocation: String = "333.1007",
        @Header("Referer") referer: String = "${BilibiliConst.MAIN_SITE_URL}/",
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ) : BiliResp<HistoryToView>

    @POST("x/v2/history/toview/add")
    @FormUrlEncoded
    suspend fun historyToViewAdd(
        @Field("aid") aid: Long,
        @Field("csrf") csrf: String,
        @Header("Referer") referer: String = "${BilibiliConst.MAIN_SITE_URL}/",
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ) : BiliResp<Unit>

    @POST("x/v2/history/toview/del")
    @FormUrlEncoded
    suspend fun historyToViewDel(
        @Field("bvids") bvids: String,
        @Field("viewed") viewed: Boolean = false,
        @Field("csrf") csrf: String,
        @Header("Referer") referer: String = "${BilibiliConst.MAIN_SITE_URL}/",
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ) : BiliResp<Unit>

    @OptIn(ExperimentalUuidApi::class)
    @FormUrlEncoded
    @POST("x/click-interface/web/heartbeat")
    suspend fun webHeartbeat(
        @QueryMap params: Map<String, String>,
        @Field("start_ts") startTs: Long,
        @Field("mid") mid: Long,
        @Field("aid") aid: Long,
        @Field("cid") cid: Long,
        @Field("played_time") playedTime: Long,
        @Field("realtime") realTime: Long,
        @Field("real_played_time") realPlayedTime: Long,
        @Field("last_play_progress_time") lastPlayProgressTime: Long,
        @Field("max_play_progress_time") maxPlayProgressTime: Long,
        @Field("quality") quality: Int,
        @Field("video_duration") videoDuration: Long,
        @Field("type") type: Int = 3,
        @Field("sub_type") subType: Int = 0,
        @Field("play_type") playType: Int = 1,
        @Field("dt") dt: Int = 2,
        @Field("outer") outer: Int = 0,
        @Field("spmid") spmId: String = "333.788.0.0",
        @Field("from_spmid") fromSpmId: String = "333.788.drama_within_video.0",
        @Field("refer_url") referUrl: String = "${BilibiliConst.MAIN_SITE_URL}/?spm_id_from=333.788.0.0",
        @Field("extra") extra: String = "{\"player_version\":\"4.9.31\"}",
        @Field("mobi_app") mobiApp: String = "web",
        @Field("device") device: String = "web",
        @Field("platform") platform: String = "web",
        @Field("session") session: String = Uuid.random().toString().replace("-", ""),
        @Field("csrf") csrf: String,
        @Header("Referer") referer: String = referUrl,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<Unit>


    @POST("x/web-interface/coin/add")
    suspend fun coinAdd(
        @Query("aid") aid: Long,
        @Query("multiply") multiply: Int = 2,
        @Query("select_like") selectLike: Int = 1,
        @Query("cross_domain") crossDomain: Boolean = true,
        @Query("eab_x") eabX: Int = 1,
        @Query("ramval") ramval: Int = 1,
        @Query("source") source: String = "web_normal",
        @Query("ga") ga: Int = 1,
        @Query("csrf") csrf: String,
        @Header("Referer") referer: String,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<CoinAdd>

    @GET("/x/relation")
    suspend fun relation(
        @QueryMap params: Map<String, String>,
        @Header("Referer") referer: String,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<FriendRelation>

    @POST("x/relation/modify")
    @FormUrlEncoded
    suspend fun relationModify(
        @Field("fid") fid: Long,
        @Field("act") act: Int = 1,
        @Field("re_src") reSrc: Int = 11,
        @Field("gaia_source") gaiaSource: String = "web_main",
        @Field("spmid") spmId: String = "333.999.0.0",
        @Field("extend_content") extendContent: String? = null,
        @Field("csrf") csrf: String,
    ): BiliResp<Unit>
}