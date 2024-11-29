package com.muedsa.tvbox.bilibili

import com.muedsa.tvbox.api.plugin.TvBoxContext
import com.muedsa.tvbox.tool.IPv6Checker
import java.io.File

val TestPlugin by lazy {
    BilibiliPlugin(
        tvBoxContext = TvBoxContext(
            screenWidth = 1920,
            screenHeight = 1080,
            debug = true,
            store = FakePluginPrefStore(
                jsonFile = File("src/test/resources/FakePluginPrefStore.json").apply {
                    if (!exists()) {
                        createNewFile()
                        writeText("{}")
                    }
                }
            ),
            iPv6Status = IPv6Checker.checkIPv6Support()
        )
    )
}