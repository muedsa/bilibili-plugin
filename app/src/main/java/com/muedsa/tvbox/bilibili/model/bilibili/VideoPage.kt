package com.muedsa.tvbox.bilibili.model.bilibili

import kotlinx.serialization.Serializable

@Serializable
data class VideoPage(
    val cid: Long = 0L,
    val page: Int = 0,
    val from: String = "", // vupload：普通上传（B站）hunan：芒果TV qq：腾讯
    val part: String = "",
    // val vid: String = ""
)
