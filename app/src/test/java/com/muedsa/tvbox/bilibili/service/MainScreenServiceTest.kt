package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.bilibili.TestPlugin
import com.muedsa.tvbox.bilibili.checkMediaCardRows
import kotlinx.coroutines.test.runTest
import org.junit.Test

class MainScreenServiceTest {

    private val service = TestPlugin.provideMainScreenService()

    @Test
    fun getRowsDataTest() = runTest{
        val rows = service.getRowsData()
        checkMediaCardRows(rows = rows)
    }

}