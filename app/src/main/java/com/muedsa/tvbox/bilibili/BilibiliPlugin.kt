package com.muedsa.tvbox.bilibili

import com.muedsa.tvbox.api.plugin.IPlugin
import com.muedsa.tvbox.api.plugin.PluginOptions
import com.muedsa.tvbox.api.plugin.TvBoxContext
import com.muedsa.tvbox.api.service.IMainScreenService
import com.muedsa.tvbox.api.service.IMediaCatalogService
import com.muedsa.tvbox.api.service.IMediaDetailService
import com.muedsa.tvbox.api.service.IMediaSearchService
import com.muedsa.tvbox.api.store.IPluginPerfStore
import com.muedsa.tvbox.bilibili.service.BilibiliApiService
import com.muedsa.tvbox.bilibili.service.BilibiliLiveApiService
import com.muedsa.tvbox.bilibili.service.BilibiliPassportService
import com.muedsa.tvbox.bilibili.service.MainScreenService
import com.muedsa.tvbox.bilibili.service.MediaCatalogService
import com.muedsa.tvbox.bilibili.service.MediaDetailService
import com.muedsa.tvbox.bilibili.service.MediaSearchService
import com.muedsa.tvbox.tool.IPv6Checker
import com.muedsa.tvbox.tool.PluginCookieJar
import com.muedsa.tvbox.tool.SharedCookieSaver
import com.muedsa.tvbox.tool.createJsonRetrofit
import com.muedsa.tvbox.tool.createOkHttpClient

class BilibiliPlugin(tvBoxContext: TvBoxContext) : IPlugin(tvBoxContext = tvBoxContext) {

    private val store: IPluginPerfStore = tvBoxContext.store

    private val cookieSaver by lazy { SharedCookieSaver(store = store) }

    private val okHttpClient by lazy {
        createOkHttpClient(
            debug = tvBoxContext.debug,
            cookieJar = PluginCookieJar(saver = cookieSaver),
            onlyIpv4 = tvBoxContext.iPv6Status != IPv6Checker.IPv6Status.SUPPORTED
        )
    }
    private val bilibiliApiService by lazy {
        createJsonRetrofit(
            baseUrl = "${BilibiliConst.API_URL}/",
            service = BilibiliApiService::class.java,
            okHttpClient = okHttpClient
        )
    }
    private val bilibiliPassportService by lazy {
        createJsonRetrofit(
            baseUrl = "${BilibiliConst.PASSPORT_URL}/",
            service = BilibiliPassportService::class.java,
            okHttpClient = okHttpClient
        )
    }
    private val bilibiliLiveApiService by lazy {
        createJsonRetrofit(
            baseUrl = "${BilibiliConst.LIVE_API_URL}/",
            service = BilibiliLiveApiService::class.java,
            okHttpClient = okHttpClient
        )
    }
    private val mainScreenService by lazy {
        MainScreenService(
            store = store,
            cookieSaver = cookieSaver,
            okHttpClient = okHttpClient,
            apiService = bilibiliApiService,
            passportService = bilibiliPassportService,
        )
    }
    private val mediaDetailService by lazy {
        MediaDetailService(
            store = store,
            cookieSaver = cookieSaver,
            okHttpClient = okHttpClient,
            passportService = bilibiliPassportService,
            apiService = bilibiliApiService,
            liveApiService = bilibiliLiveApiService,
        )
    }
    private val mediaSearchService by lazy { MediaSearchService() }
    private val mediaCatalogService by lazy { MediaCatalogService() }

    override fun provideMainScreenService(): IMainScreenService = mainScreenService

    override fun provideMediaDetailService(): IMediaDetailService = mediaDetailService

    override fun provideMediaSearchService(): IMediaSearchService = mediaSearchService

    override fun provideMediaCatalogService(): IMediaCatalogService = mediaCatalogService

    override suspend fun onInit() {}
    override suspend fun onLaunched() {}
    override var options: PluginOptions = PluginOptions(enableDanDanPlaySearch = false)
}