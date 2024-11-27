package com.muedsa.tvbox.bilibili

object BilibiliConst {

    const val MAIN_SITE_URL = "https://www.bilibili.com"
    const val API_URL = "https://api.bilibili.com"
    const val PASSPORT_URL = "https://passport.bilibili.com"

    const val AV_CARD_WIDTH = 178
    const val AV_CARD_HEIGHT = 100
    const val AVATAR_CARD_WIDTH = 100
    const val AVATAR_CARD_HEIGHT = 100
    const val BUTTON_CARD_WIDTH = 178
    const val BUTTON_CARD_HEIGHT = 100
    const val QRCODE_CARD_WIDTH = 200
    const val QRCODE_CARD_HEIGHT = 200

    val QUALITY = mapOf(
        16 to "流畅 360P",
        32 to "清晰 480P",
        64 to "高清 720P60",
        80 to "高清 1080P",
        112 to "高清 1080P+",
        116 to "高清 1080P60",
        120 to "超清 4K",
        125 to "真彩 HDR",
        127 to "超高清 8K",
    )
}