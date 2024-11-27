package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.bilibili.TestPlugin
import com.muedsa.tvbox.bilibili.checkMediaCardRow
import kotlinx.coroutines.test.runTest
import org.junit.Test

class MediaSearchServiceTest {

    private val service = TestPlugin.provideMediaSearchService()

    @Test
    fun searchMedias_test() = runTest {
        val row = service.searchMedias("GIRLS BAND CRY")
        checkMediaCardRow(row = row)
    }
}