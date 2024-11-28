package com.muedsa.tvbox.bilibili.helper

import kotlin.random.Random

object BiliApiHelper {

    fun generateFixedLengthRandomNumber(length: Int): String {
        val sb = StringBuilder()
        for (i in 1..length) {
            sb.append(Random.nextInt(0, 10))  // 生成0到9的随机整数，追加到字符串构建器中
        }
        return sb.toString()
    }

    fun buildTopFeedRcmdParams(
        uniqId: String,
        index: Int = 1,
        lastShowList: String = "",
        mixinKey: String
    ): MutableMap<String, String> {
        val params = mutableMapOf<String, String>(
            "fresh_type" to "4",
            "ps" to "30",
            "fresh_idx" to "$index",
            "fresh_idx_1h" to "$index",
            "brush" to "$index",
            "fetch_row" to "${index * 6 + 1}",
            "y_num" to "6",
            "last_y_num" to "6",
            "web_location" to "1430650",
            "feed_version" to "V8",
            "homepage_ver" to "1",
            "screen" to "4096-1999",
            "seo_info" to "",
            "last_showlist" to lastShowList,
            "uniq_id" to uniqId
        )
        WBIHelper.fillWbiParams(params = params, mixinKey = mixinKey)
        return params
    }

    fun buildWbiPlayUrlParams(
        bvid: String,
        cid: Long,
        qn: Int = 80,
        session: String,
        mixinKey: String,
    ):  MutableMap<String, String> {
        val params = mutableMapOf<String, String>(
            "bvid" to bvid,
            "cid" to "$cid",
            "qn" to "$qn",
            "fnval" to "1",
            "fnver" to "0",
            "fourk" to "1",
            "session" to session,
            "otype" to "json",
            "type" to "",
            "platform" to "web",
        )
        WBIHelper.fillWbiParams(params = params, mixinKey = mixinKey)
        return params
    }

    fun buildSearchParams(
        keyword: String,
        searchType: String,
        mixinKey: String,
    ): MutableMap<String, String> {
        val params = mutableMapOf<String, String>(
            "search_type" to searchType,
            "keyword" to keyword,
        )
        WBIHelper.fillWbiParams(params = params, mixinKey = mixinKey)
        return params
    }
}