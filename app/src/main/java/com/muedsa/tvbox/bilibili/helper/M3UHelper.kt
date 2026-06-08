package com.muedsa.tvbox.bilibili.helper

import com.muedsa.tvbox.api.data.MediaEpisode
import com.muedsa.tvbox.api.data.MediaPlaySource
import com.muedsa.tvbox.bilibili.service.MediaDetailService.Companion.MEDIA_ID_LIVE_ROOM_PREFIX

object M3UHelper {

    fun getLiveMediaPlaySourceList(text: String, roomId: Long): List<MediaPlaySource>? {
        if (!text.startsWith("#EXTM3U")) {
            return null
        }
        val episodeList = mutableListOf<MediaEpisode>()
        val lines = text.reader().readLines()
        var i = 0
        while (i < lines.size) {
            val line = lines[i]
            if (line.startsWith("#EXT-X-STREAM-INF:")) {
                val inf = parseExtStreamInf(line)
                i++
                episodeList.add(
                    MediaEpisode(
                        id = "$MEDIA_ID_LIVE_ROOM_PREFIX${roomId}",
                        name = "${inf["BILI-DISPLAY"]} ${inf["RESOLUTION"]} ${inf["CODECS"]}",
                        flag3 = roomId,
                        flag5 = lines[i],
                    )
                )
            }
            i++
        }
        return listOf(
            MediaPlaySource(
                id = "bilibili_live",
                name = "哔哩哔哩直播",
                episodeList = episodeList,
            )
        )
    }

    fun parseExtStreamInf(line: String): Map<String, String> {
        if (!line.startsWith("#EXT-X-STREAM-INF:")) return emptyMap()

        // 1. 去掉前缀
        val content = line.removePrefix("#EXT-X-STREAM-INF:").trim()
        val attributes = mutableMapOf<String, String>()

        // 状态标记：是否在双引号内（引号内的逗号不分割）
        var inQuotes = false
        val currentPair = StringBuilder()

        // 2. 逐字符遍历，按【引号外的逗号】分割属性
        for (char in content) {
            when (char) {
                '"' -> inQuotes = !inQuotes // 切换引号状态
                ',' -> {
                    if (!inQuotes) {
                        // 仅引号外的逗号才分割属性
                        parseKeyValue(currentPair.toString(), attributes)
                        currentPair.clear()
                        continue
                    }
                    // 引号内的逗号，直接保留
                    currentPair.append(char)
                }

                else -> currentPair.append(char)
            }
        }

        // 处理最后一个属性
        if (currentPair.isNotEmpty()) {
            parseKeyValue(currentPair.toString(), attributes)
        }

        return attributes
    }

    /**
     * 解析单个 key=value 键值对（自动去除值的双引号）
     */
    private fun parseKeyValue(pair: String, map: MutableMap<String, String>) {
        val trimmed = pair.trim()
        val eqIndex = trimmed.indexOf('=')
        if (eqIndex == -1) return

        val key = trimmed.substring(0, eqIndex).trim()
        val value = trimmed.substring(eqIndex + 1).trim().removeSurrounding("\"")
        map[key] = value
    }
}