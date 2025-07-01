package com.muedsa.tvbox.bilibili.helper

import com.muedsa.tvbox.api.store.IPluginPerfStore
import com.muedsa.tvbox.tool.LenientJson
import kotlinx.serialization.json.JsonPrimitive

object DebugHelper {

    suspend fun toJsonStr(store: IPluginPerfStore): String {
        val storeJsonMap = store.filter { true }.map {
            val jsonValue = when (it.value) {
                is Number -> JsonPrimitive(it.value as Number)
                is Boolean -> JsonPrimitive(it.value as Boolean)
                is String -> JsonPrimitive(it.value as String)
                else -> throw RuntimeException("[${it.value}] can not to json")
            }
            it.key to jsonValue
        }.toMap()
        return LenientJson.encodeToString(storeJsonMap)
    }
}