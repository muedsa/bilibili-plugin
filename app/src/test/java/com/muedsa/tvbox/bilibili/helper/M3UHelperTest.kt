package com.muedsa.tvbox.bilibili.helper

import org.junit.Test

class M3UHelperTest {

    @Test
    fun parseExtStreamInfTest() {
        val hlsLine =
            "#EXT-X-STREAM-INF:BANDWIDTH=1066971,RESOLUTION=1920x1080,CODECS=\"avc1.640032,mp4a.40.2\",BILI-ORDER=0,BILI-DISPLAY=\"原画\",BILI-QN=10000,PATHWAY-ID=\"https://cn-zjhz-cu-01-01.bilivideo.com\",BILI-STREAM=\"live_28677456_2568667\"\n"
        val attributes = M3UHelper.parseExtStreamInf(hlsLine)
        attributes.forEach { (k, v) -> println("$k = $v") }
    }
}