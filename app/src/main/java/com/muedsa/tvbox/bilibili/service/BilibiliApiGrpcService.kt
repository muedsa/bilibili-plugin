package com.muedsa.tvbox.bilibili.service

import com.bapis.bilibili.community.service.dm.v1.DmSegMobileReply
import com.muedsa.tvbox.tool.ChromeUserAgent
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.QueryMap

interface BilibiliApiGrpcService {

    @GET("x/v2/dm/web/seg.so")
    suspend fun dmWbiWebSegSo(
        @QueryMap queryMap: Map<String, String>,
        @Header("User-Agent") userAgent: String = ChromeUserAgent,
    ) : DmSegMobileReply

}