package com.muedsa.tvbox.bilibili.helper

import com.muedsa.tvbox.tool.md5
import java.net.URLDecoder
import java.net.URLEncoder

object WBIHelper {
    const val QUERY_KEY_WTS = "wts"
    const val QUERY_KEY_W_RID = "w_rid"

    private val MIXIN_KEY_ENC_TABLE = intArrayOf(
        46, 47, 18, 2, 53, 8, 23, 32, 15, 50, 10, 31, 58, 3, 45, 35, 27, 43, 5, 49,
        33, 9, 42, 19, 29, 28, 14, 39, 12, 38, 41, 13, 37, 48, 7, 16, 24, 55, 40,
        61, 26, 17, 0, 1, 60, 51, 30, 4, 22, 25, 54, 21, 56, 59, 6, 63, 57, 62, 11,
        36, 20, 34, 44, 52
    )

    fun getMixinKey(imgKey: String, subKey: String): String {
        val s = imgKey + subKey
        val key = StringBuilder()
        for (i in 0 until 32) {
            key.append(s[MIXIN_KEY_ENC_TABLE[i]])
        }
        return key.toString()
    }

    fun stringSortedParams(params: Map<String, String>): String {
        val param = params.entries.sortedBy { it.key }.joinToString("&") {
            "${it.key.encodeURIComponent()}=${it.value.encodeURIComponent()}"
        }
        return param
    }

    fun fillWbiParams(params: MutableMap<String, String>, imgKey: String, subKey: String) {
        val mixinKey = getMixinKey(imgKey, subKey)
        fillWbiParams(params, mixinKey)
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun fillWbiParams(params: MutableMap<String, String>, mixinKey: String) {
        params[QUERY_KEY_WTS] = (System.currentTimeMillis() / 1000).toString()
        val sortedParams = stringSortedParams(params) + mixinKey
        val md5Bytes = sortedParams.md5()
        val hexEncoded = md5Bytes.toHexString()
        params[QUERY_KEY_W_RID] = hexEncoded
    }

    fun String.encodeURIComponent(): String = URLEncoder.encode(this, Charsets.UTF_8.name())

    fun String.decodeURIComponent(): String = URLDecoder.decode(this, Charsets.UTF_8.name())
}