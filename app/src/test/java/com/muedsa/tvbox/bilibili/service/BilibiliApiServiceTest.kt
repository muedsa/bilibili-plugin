package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.bilibili.BILI_WBI_MIXIN_KEY
import com.muedsa.tvbox.bilibili.BilibiliConst
import com.muedsa.tvbox.bilibili.TestCookieSaver
import com.muedsa.tvbox.bilibili.TestOkHttpClient
import com.muedsa.tvbox.bilibili.TestPluginPrefStore
import com.muedsa.tvbox.bilibili.helper.BiliApiHelper
import com.muedsa.tvbox.bilibili.helper.BiliCookieHelper
import com.muedsa.tvbox.tool.createJsonRetrofit
import com.muedsa.tvbox.tool.md5
import kotlinx.coroutines.test.runTest
import org.junit.Test

class BilibiliApiServiceTest {

    private val apiService by lazy {
        createJsonRetrofit(
            baseUrl = "${BilibiliConst.API_URL}/",
            service = BilibiliApiService::class.java,
            okHttpClient = TestOkHttpClient
        )
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun wbiPlayUrl_test() = runTest {
        val aid = 1155178644L
        val bv = "BV1fx421S79u"
        val cid = 1495297177L
        val b3 = BiliCookieHelper.getCookeValue(
            cookieSaver = TestCookieSaver,
            cookieName = BiliCookieHelper.COOKIE_B_3
        )
        val session = "$b3${System.currentTimeMillis()}".md5().toHexString()
        val resp = apiService.wbiPlayUrl(
            BiliApiHelper.buildWbiPlayUrlParams(
                aid = aid,
                bvid = bv,
                cid = cid,
                session = session,
                mixinKey = TestPluginPrefStore.get(BILI_WBI_MIXIN_KEY)
                    ?: throw RuntimeException("WBI鉴权参数未获取")
            ),
            referer = "${BilibiliConst.MAIN_SITE_URL}/video/$bv?spm_id_from=333.1007.tianma.1-1-1.click"
        )
        check(resp.code == 0L)
    }

}