package com.muedsa.tvbox.bilibili

import com.muedsa.tvbox.api.plugin.TvBoxContext
import com.muedsa.tvbox.tool.IPv6Checker
import com.muedsa.tvbox.tool.PluginCookieJar
import com.muedsa.tvbox.tool.SharedCookieSaver
import com.muedsa.tvbox.tool.createOkHttpClient
import java.io.File

val TestPlugin by lazy {
    BilibiliPlugin(
        tvBoxContext = TvBoxContext(
            screenWidth = 1920,
            screenHeight = 1080,
            debug = true,
            store = TestPluginPrefStore,
            iPv6Status = IPv6Checker.checkIPv6Support()
        )
    )
}

val TestPluginPrefStore by lazy {
    FakePluginPrefStore(
        jsonFile = File("src/test/resources/FakePluginPrefStore.json").apply {
            if (!exists()) {
                createNewFile()
                writeText("{}")
            }
        }
    )
}

val TestCookieSaver by lazy { SharedCookieSaver(store = TestPluginPrefStore) }

val TestOkHttpClient by lazy {
    createOkHttpClient(
        debug = true,
        cookieJar = PluginCookieJar(saver = TestCookieSaver),
        onlyIpv4 = true
    )
}