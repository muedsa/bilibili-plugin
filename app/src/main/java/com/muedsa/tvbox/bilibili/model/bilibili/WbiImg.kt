package com.muedsa.tvbox.bilibili.model.bilibili

import com.muedsa.tvbox.bilibili.helper.WBIHelper
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import okhttp3.HttpUrl.Companion.toHttpUrl

@Serializable
data class WbiImg(
    @SerialName("img_url") val imgUrl: String,
    @SerialName("sub_url") val subUrl: String,
) {
    val imgKey by lazy { parseKey(imgUrl) }
    val subKey by lazy { parseKey(subUrl) }
    val mixinKey by lazy { WBIHelper.getMixinKey(imgKey = imgKey, subKey = subKey) }

    companion object {
        fun parseKey(url: String) : String {
            val httpUrl = url.toHttpUrl()
            return httpUrl.pathSegments[httpUrl.pathSize - 1].removeSuffix(".png")
        }
    }
}
