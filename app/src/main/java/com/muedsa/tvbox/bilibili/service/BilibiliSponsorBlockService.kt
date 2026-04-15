package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.bilibili.model.bsb.Segment
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface BilibiliSponsorBlockService {

    @GET("api/skipSegments")
    suspend fun skipSegments(
        @Query("videoID") videoID: String,
        @Query("cid") cid: Long,
        @Query("category") category: String = "sponsor",
        @Query("actionType") actionType: String = "skip",
        @Header("User-Agent") userAgent: String = "com.muedsa.tvbox.bilibili",
        @Header("origin") origin: String = "https://github.com/muedsa/bilibili-plugin",
        @Header("x-ext-version") xExtVersion: String = "0.0.0",
    ): List<Segment>

}