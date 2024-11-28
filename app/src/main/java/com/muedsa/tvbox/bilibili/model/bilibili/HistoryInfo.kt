package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class HistoryInfo(
    val business: String = "",
    val bvid: String = "",
    val cid: Long = 0L,
    val dt: Int = 0, // 1 3 5 7：手机端 2：web端 4 6：pad端 33：TV端 0：其他
    val epid: Long = 0L,
    val oid: Long = 0L,
    val page: Int = 0,
    val part: String = "",
)
