package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.bilibili.model.bilibili.BiliResp
import com.muedsa.tvbox.bilibili.model.bilibili.LoginExit
import com.muedsa.tvbox.bilibili.model.bilibili.PassportCookieInfo
import com.muedsa.tvbox.bilibili.model.bilibili.PassportQRCode
import com.muedsa.tvbox.bilibili.model.bilibili.PassportQRCodePoll
import com.muedsa.tvbox.bilibili.model.bilibili.PassportRefreshCookie
import com.muedsa.tvbox.tool.ChromeUserAgent
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface BilibiliPassportService {

    @GET("x/passport-login/web/qrcode/generate")
    suspend fun qrcodeGenerate(
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<PassportQRCode>

    @GET("x/passport-login/web/qrcode/poll")
    suspend fun qrcodePoll(
        @Query("qrcode_key") qrcodeKey: String,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<PassportQRCodePoll>

    @GET("x/passport-login/web/cookie/info")
    suspend fun cookieInfo(
        @Query("csrf") csrf: String,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ): BiliResp<PassportCookieInfo>

    @POST("x/passport-login/web/cookie/refresh")
    suspend fun cookieRefresh(
        @Query("csrf") csrf: String,
        @Query("refresh_csrf") refreshCsrf: String,
        @Query("source") source: String = "main_web",
        @Query("refresh_token") refreshToken: String,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ) : BiliResp<PassportRefreshCookie>

    @POST("x/passport-login/web/confirm/refresh")
    suspend fun confirmRefresh(
        @Query("csrf") csrf: String,
        @Query("refresh_token") refreshToken: String,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ) : BiliResp<Unit>

    @FormUrlEncoded
    @POST("login/exit/v2")
    suspend fun loginExitV2(
        @Field("biliCSRF") biliCSRF: String,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ) : BiliResp<LoginExit>
}