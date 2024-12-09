package com.muedsa.tvbox.bilibili.helper

import kotlin.random.Random

object BiliApiHelper {

    const val DM_IMG_STR = "V2ViR0wgMS4wIChPcGVuR0wgRVMgMi4wIENocm9taXVtKQ"
    const val DM_COVER_IMG_STR = "QU5HTEUgKEludGVsLCBJbnRlbChSKSBVSEQgR3JhcGhpY3MgNjMwICgweDAwMDA5QkM4KSBEaXJlY3QzRDExIHZzXzVfMCBwc181XzAsIEQzRDExKUdvb2dsZSBJbmMuIChJbnRlbC"

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
        aid: Long,
        bvid: String,
        cid: Long,
        qn: Int = 127,
        fnval: Int = 4080,
        session: String,
        mixinKey: String,
    ):  MutableMap<String, String> {
        val params = mutableMapOf<String, String>(
            "aid" to "$aid",
            "bvid" to bvid,
            "cid" to "$cid",
            "qn" to "$qn",
            "fnval" to "$fnval",
            "fnver" to "0",
            "fourk" to "1",
            "gaia_source" to "",
            "from_client" to "BROWSER",
            "is_main_page" to "true",
            "need_fragment" to "false",
            "isGaiaAvoided" to "false",
            "voice_balance" to "1",
            "web_location" to "1315873",
            "try_look" to "1",
            "dm_img_list" to "[{\"x\":2498,\"y\":-1806,\"z\":0,\"timestamp\":3023,\"k\":74,\"type\":0},{\"x\":2612,\"y\":-1686,\"z\":96,\"timestamp\":3524,\"k\":66,\"type\":0},{\"x\":2670,\"y\":-1629,\"z\":65,\"timestamp\":3624,\"k\":80,\"type\":0},{\"x\":2796,\"y\":-1669,\"z\":45,\"timestamp\":3724,\"k\":67,\"type\":0},{\"x\":3015,\"y\":-1661,\"z\":69,\"timestamp\":3824,\"k\":102,\"type\":0},{\"x\":3006,\"y\":-1682,\"z\":50,\"timestamp\":3956,\"k\":69,\"type\":0},{\"x\":4156,\"y\":396,\"z\":141,\"timestamp\":4396,\"k\":95,\"type\":0},{\"x\":5228,\"y\":2393,\"z\":600,\"timestamp\":4497,\"k\":94,\"type\":0},{\"x\":5502,\"y\":2715,\"z\":822,\"timestamp\":4602,\"k\":82,\"type\":0},{\"x\":4887,\"y\":1662,\"z\":279,\"timestamp\":4702,\"k\":97,\"type\":0},{\"x\":4841,\"y\":981,\"z\":735,\"timestamp\":4803,\"k\":116,\"type\":0},{\"x\":4063,\"y\":-292,\"z\":499,\"timestamp\":4904,\"k\":84,\"type\":0},{\"x\":3934,\"y\":-163,\"z\":332,\"timestamp\":5004,\"k\":95,\"type\":0},{\"x\":5424,\"y\":3021,\"z\":1271,\"timestamp\":5104,\"k\":117,\"type\":0},{\"x\":4799,\"y\":2347,\"z\":632,\"timestamp\":5206,\"k\":71,\"type\":0},{\"x\":4952,\"y\":2035,\"z\":1214,\"timestamp\":5307,\"k\":88,\"type\":0},{\"x\":3553,\"y\":113,\"z\":418,\"timestamp\":5409,\"k\":65,\"type\":0},{\"x\":4054,\"y\":-328,\"z\":893,\"timestamp\":5509,\"k\":122,\"type\":0},{\"x\":4342,\"y\":-881,\"z\":1151,\"timestamp\":5610,\"k\":117,\"type\":0},{\"x\":4442,\"y\":-884,\"z\":1192,\"timestamp\":5711,\"k\":89,\"type\":0},{\"x\":5107,\"y\":4214,\"z\":1116,\"timestamp\":5812,\"k\":96,\"type\":0},{\"x\":3987,\"y\":5186,\"z\":114,\"timestamp\":5916,\"k\":107,\"type\":0},{\"x\":4001,\"y\":4234,\"z\":1347,\"timestamp\":10574,\"k\":113,\"type\":0},{\"x\":5476,\"y\":-83,\"z\":1453,\"timestamp\":10748,\"k\":99,\"type\":0},{\"x\":6035,\"y\":374,\"z\":1950,\"timestamp\":10902,\"k\":69,\"type\":0},{\"x\":4512,\"y\":-1414,\"z\":1199,\"timestamp\":15540,\"k\":85,\"type\":0},{\"x\":6160,\"y\":590,\"z\":2653,\"timestamp\":15640,\"k\":110,\"type\":0},{\"x\":3691,\"y\":-1870,\"z\":180,\"timestamp\":15744,\"k\":89,\"type\":0},{\"x\":5649,\"y\":116,\"z\":2123,\"timestamp\":16076,\"k\":71,\"type\":0},{\"x\":7950,\"y\":5435,\"z\":2730,\"timestamp\":16176,\"k\":101,\"type\":0},{\"x\":8023,\"y\":5708,\"z\":2387,\"timestamp\":16277,\"k\":87,\"type\":0},{\"x\":7009,\"y\":4212,\"z\":1439,\"timestamp\":16378,\"k\":69,\"type\":0},{\"x\":8157,\"y\":5334,\"z\":2596,\"timestamp\":16480,\"k\":86,\"type\":0},{\"x\":9229,\"y\":6406,\"z\":3668,\"timestamp\":16678,\"k\":70,\"type\":1}]",
            "dm_img_str" to DM_IMG_STR,
            "dm_cover_img_str" to DM_COVER_IMG_STR,
            "dm_img_inter" to "{\"ds\":[{\"t\":2,\"c\":\"dGl0bGUtdH\",\"p\":[3997,43,1139],\"s\":[198,1196,1520]}],\"wh\":[5921,6842,81],\"of\":[189,378,189]}",
            "session" to session,
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

    fun buildPopularParams(
        page: Int = 1,
        pageSize: Int = 20,
        mixinKey: String
    ): MutableMap<String, String> {
        val params = mutableMapOf<String, String>(
            "pn" to "$page",
            "ps" to "$pageSize",
            "web_location" to "333.934",
        )
        WBIHelper.fillWbiParams(params = params, mixinKey = mixinKey)
        return params
    }

    fun buildWbiAccInfoParams(
        mid: Long,
        wWebId: String,
        mixinKey: String,
    ): MutableMap<String, String> {
        val params = mutableMapOf<String, String>(
            "mid" to "$mid",
            "token" to "",
            "platform" to "web",
            "web_location" to "1550101",
            "dm_img_list" to "[]",
            "dm_img_str" to DM_IMG_STR,
            "dm_cover_img_str" to DM_COVER_IMG_STR,
            "dm_img_inter" to "{\"ds\":[],\"wh\":[5711,6772,11],\"of\":[245,490,245]}",
            "w_webid" to wWebId,
        )
        WBIHelper.fillWbiParams(params = params, mixinKey = mixinKey)
        return params
    }

    fun buildWbiArcSearchParams(
        page: Int = 1,
        pageSize: Int = 30,
        mid: Long,
        wWebId: String,
        mixinKey: String,
    ): MutableMap<String, String> {
        val params = mutableMapOf<String, String>(
            "mid" to "$mid",
            "ps" to "$pageSize",
            "tid" to "0",
            "pn" to "$page",
            "keyword" to "",
            "order" to "pubdate",
            "platform" to "web",
            "web_location" to "1550101",
            "order_avoided" to "true",
            "dm_img_list" to "[{\"x\":2299,\"y\":1187,\"z\":0,\"timestamp\":2658,\"k\":113,\"type\":0},{\"x\":2361,\"y\":1215,\"z\":49,\"timestamp\":2770,\"k\":68,\"type\":0},{\"x\":2534,\"y\":1309,\"z\":160,\"timestamp\":2909,\"k\":95,\"type\":0},{\"x\":2600,\"y\":1216,\"z\":128,\"timestamp\":3009,\"k\":120,\"type\":0},{\"x\":2648,\"y\":1250,\"z\":172,\"timestamp\":3137,\"k\":66,\"type\":0},{\"x\":2939,\"y\":1424,\"z\":423,\"timestamp\":3365,\"k\":120,\"type\":0},{\"x\":2886,\"y\":1239,\"z\":306,\"timestamp\":3545,\"k\":113,\"type\":0},{\"x\":2870,\"y\":1152,\"z\":250,\"timestamp\":3646,\"k\":122,\"type\":0},{\"x\":2706,\"y\":814,\"z\":33,\"timestamp\":3747,\"k\":103,\"type\":0},{\"x\":2906,\"y\":1195,\"z\":357,\"timestamp\":3847,\"k\":90,\"type\":0},{\"x\":2928,\"y\":1450,\"z\":600,\"timestamp\":3949,\"k\":124,\"type\":0},{\"x\":3312,\"y\":1850,\"z\":1074,\"timestamp\":4051,\"k\":96,\"type\":0},{\"x\":3527,\"y\":2050,\"z\":1311,\"timestamp\":4151,\"k\":100,\"type\":0},{\"x\":2631,\"y\":1154,\"z\":415,\"timestamp\":4285,\"k\":94,\"type\":1},{\"x\":2372,\"y\":896,\"z\":153,\"timestamp\":4848,\"k\":121,\"type\":0},{\"x\":3506,\"y\":2064,\"z\":1300,\"timestamp\":5089,\"k\":95,\"type\":0},{\"x\":1730,\"y\":1427,\"z\":224,\"timestamp\":5190,\"k\":96,\"type\":0},{\"x\":2061,\"y\":1904,\"z\":600,\"timestamp\":5290,\"k\":109,\"type\":0},{\"x\":1620,\"y\":1813,\"z\":328,\"timestamp\":5391,\"k\":77,\"type\":0},{\"x\":2120,\"y\":2510,\"z\":881,\"timestamp\":5491,\"k\":106,\"type\":0},{\"x\":2577,\"y\":2978,\"z\":1351,\"timestamp\":5597,\"k\":66,\"type\":0},{\"x\":2465,\"y\":2873,\"z\":1241,\"timestamp\":5701,\"k\":72,\"type\":0},{\"x\":3101,\"y\":3486,\"z\":1900,\"timestamp\":8062,\"k\":72,\"type\":0},{\"x\":2510,\"y\":196,\"z\":735,\"timestamp\":8163,\"k\":87,\"type\":0},{\"x\":4087,\"y\":1265,\"z\":2226,\"timestamp\":8264,\"k\":117,\"type\":0},{\"x\":2883,\"y\":49,\"z\":1012,\"timestamp\":8364,\"k\":100,\"type\":0},{\"x\":1930,\"y\":-717,\"z\":4,\"timestamp\":8466,\"k\":98,\"type\":0},{\"x\":4710,\"y\":2234,\"z\":2685,\"timestamp\":8566,\"k\":112,\"type\":0},{\"x\":4550,\"y\":2076,\"z\":2519,\"timestamp\":8666,\"k\":76,\"type\":0},{\"x\":2529,\"y\":63,\"z\":497,\"timestamp\":8774,\"k\":68,\"type\":0},{\"x\":3201,\"y\":736,\"z\":1166,\"timestamp\":8876,\"k\":123,\"type\":0},{\"x\":2204,\"y\":-243,\"z\":161,\"timestamp\":8976,\"k\":105,\"type\":0},{\"x\":4711,\"y\":2531,\"z\":2304,\"timestamp\":9076,\"k\":85,\"type\":0},{\"x\":3114,\"y\":964,\"z\":686,\"timestamp\":9176,\"k\":119,\"type\":0},{\"x\":2194,\"y\":19,\"z\":117,\"timestamp\":9277,\"k\":114,\"type\":0},{\"x\":2528,\"y\":383,\"z\":637,\"timestamp\":9379,\"k\":94,\"type\":0},{\"x\":5911,\"y\":3773,\"z\":4022,\"timestamp\":9487,\"k\":74,\"type\":0},{\"x\":2275,\"y\":137,\"z\":386,\"timestamp\":9587,\"k\":119,\"type\":1},{\"x\":3762,\"y\":1617,\"z\":1871,\"timestamp\":10060,\"k\":60,\"type\":0},{\"x\":4782,\"y\":1925,\"z\":2635,\"timestamp\":10161,\"k\":91,\"type\":0},{\"x\":5964,\"y\":2299,\"z\":3573,\"timestamp\":10261,\"k\":83,\"type\":0},{\"x\":3345,\"y\":-149,\"z\":993,\"timestamp\":10361,\"k\":67,\"type\":0},{\"x\":5491,\"y\":2748,\"z\":3370,\"timestamp\":10461,\"k\":74,\"type\":0},{\"x\":2579,\"y\":66,\"z\":527,\"timestamp\":10562,\"k\":102,\"type\":0},{\"x\":6688,\"y\":4250,\"z\":4687,\"timestamp\":10664,\"k\":84,\"type\":0},{\"x\":6268,\"y\":3830,\"z\":4267,\"timestamp\":10804,\"k\":104,\"type\":1},{\"x\":5687,\"y\":3250,\"z\":3683,\"timestamp\":11267,\"k\":107,\"type\":0},{\"x\":2055,\"y\":-210,\"z\":64,\"timestamp\":11368,\"k\":80,\"type\":0},{\"x\":6810,\"y\":4676,\"z\":4863,\"timestamp\":11469,\"k\":67,\"type\":0},{\"x\":2553,\"y\":447,\"z\":614,\"timestamp\":11575,\"k\":87,\"type\":0}]",
            "dm_img_str" to DM_IMG_STR,
            "dm_cover_img_str" to DM_COVER_IMG_STR,
            "dm_img_inter" to "{\"ds\":[{\"t\":2,\"c\":\"Y2xlYXJmaXggZy1zZWFyY2ggc2VhcmNoLWNvbnRhaW5lcg\",\"p\":[2106,28,387],\"s\":[234,696,884]},{\"t\":2,\"c\":\"d3JhcHBlcg\",\"p\":[1407,41,1059],\"s\":[510,5035,4800]}],\"wh\":[5690,6765,4],\"of\":[418,836,418]}",
            "w_webid" to wWebId,
        )
        WBIHelper.fillWbiParams(params = params, mixinKey = mixinKey)
        return params
    }

    fun buildDmWbiWebSegSoParams(
        oid: Long,
        segmentIndex: Int,
        mixinKey: String,
    ): MutableMap<String, String> {
        val params = mutableMapOf<String, String>(
            "type" to "1",
            "oid" to "$oid",
            "segment_index" to "$segmentIndex",
        )
        WBIHelper.fillWbiParams(params = params, mixinKey = mixinKey)
        return params
    }


    fun buildWebHeartbeatParams(
        startTs: Long,
        mid: Long,
        aid: Long,
        realTime: Long,
        playedTime: Long,
        realPlayedTime: Long,
        videoDuration: Long,
        lastPlayProgressTime: Long,
        mixinKey: String,
    ): MutableMap<String, String> {
        val params = mutableMapOf<String, String>(
            "w_start_ts" to "$startTs",
            "w_mid" to "$mid",
            "w_aid" to "$aid",
            "w_realtime" to "$realTime",
            "w_playedtime" to "$playedTime",
            "w_real_played_time" to "$realPlayedTime",
            "w_video_duration" to "$videoDuration",
            "w_last_play_progress_time" to "$lastPlayProgressTime",
            "w_dt" to "2",
            "web_location" to "1315873",
        )
        WBIHelper.fillWbiParams(params = params, mixinKey = mixinKey)
        return params
    }

}