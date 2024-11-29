package com.muedsa.tvbox.bilibili

import com.muedsa.tvbox.api.store.IPluginPerfStore
import com.muedsa.tvbox.api.store.PluginPerfKey
import com.muedsa.tvbox.tool.LenientJson
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.floatOrNull
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.longOrNull
import java.io.File
import kotlin.reflect.typeOf

@Suppress("UNCHECKED_CAST")
class FakePluginPrefStore(
    val jsonFile: File
) : IPluginPerfStore {

    private val store: MutableMap<String, JsonPrimitive>
        = LenientJson.decodeFromString<MutableMap<String, JsonPrimitive>>(jsonFile.readText())

    override suspend fun <T> get(key: PluginPerfKey<T>): T? {
        val keyTypes = key::class.supertypes
        val value = store[key.name]
        if (value == null) return null
        val v = if(keyTypes.any { it == STRING_TYPE }) {
            value.contentOrNull
        } else if(keyTypes.any { it == INT_TYPE }) {
            value.intOrNull
        } else if(keyTypes.any { it == LONG_TYPE }) {
            value.longOrNull
        } else if(keyTypes.any { it == BOOLEAN_TYPE }) {
            value.booleanOrNull
        } else if(keyTypes.any { it == FLOAT_TYPE }) {
            value.floatOrNull
        } else if(keyTypes.any { it == DOUBLE_TYPE }) {
            value.doubleOrNull
        } else if(keyTypes.any { it == BYTE_ARRAY_TYPE }) {
            throw RuntimeException("不支持的类型 $key")
        } else throw RuntimeException("不支持的类型 $key")
        return v as T?
    }

    override suspend fun <T> getOrDefault(key: PluginPerfKey<T>, default: T): T =
        get(key) ?: default

    override suspend fun filter(predicate: (String) -> Boolean): Map<String, Any> {
        val filterMap = store.filter { predicate(it.key) }
        if (filterMap.isEmpty()) return emptyMap()
        val map = mutableMapOf<String, Any>()
        filterMap.forEach { k, v ->
            // 插件里全是String类型的
            // 如果有特别的key需要在这里处理
            map.put(k, v.contentOrNull as Any)
        }
        return map
    }

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun <T> update(key: PluginPerfKey<T>, value: T) {
        store[key.name] = when(value) {
            is Boolean -> JsonPrimitive(value)
            is Number -> JsonPrimitive(value)
            is String -> JsonPrimitive(value)
            else -> throw RuntimeException("$key=$value cannot to json")
        }
        jsonFile.writeText(LenientJson.encodeToString(store))
    }

    override suspend fun <T> remove(key: PluginPerfKey<T>) {
        store.remove(key.name)
        jsonFile.writeText(LenientJson.encodeToString(store))
    }

    companion object {
        val STRING_TYPE = typeOf<PluginPerfKey<String>>()
        val INT_TYPE = typeOf<PluginPerfKey<Int>>()
        val LONG_TYPE = typeOf<PluginPerfKey<Long>>()
        val BOOLEAN_TYPE = typeOf<PluginPerfKey<Boolean>>()
        val FLOAT_TYPE = typeOf<PluginPerfKey<Float>>()
        val DOUBLE_TYPE = typeOf<PluginPerfKey<Float>>()
        val BYTE_ARRAY_TYPE = typeOf<PluginPerfKey<ByteArray>>()
    }
}