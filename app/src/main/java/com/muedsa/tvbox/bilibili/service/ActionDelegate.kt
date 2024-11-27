package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.api.data.MediaCard
import com.muedsa.tvbox.api.data.MediaCardRow
import com.muedsa.tvbox.api.data.MediaDetail
import com.muedsa.tvbox.api.data.SavedMediaCard
import com.muedsa.tvbox.api.store.IPluginPerfStore
import com.muedsa.tvbox.bilibili.BILI_REFRESH_TOKEN_KEY
import com.muedsa.tvbox.bilibili.BilibiliConst
import com.muedsa.tvbox.bilibili.model.LoginState
import com.muedsa.tvbox.bilibili.model.QRCodeLoginCache
import com.muedsa.tvbox.tool.LenientJson
import com.muedsa.tvbox.tool.feignChrome
import com.muedsa.tvbox.tool.get
import com.muedsa.tvbox.tool.parseHtml
import com.muedsa.tvbox.tool.toRequestBuild
import kotlinx.serialization.encodeToString
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import timber.log.Timber

class ActionDelegate(
    private val passportService: BilibiliPassportService,
    private val okHttpClient: OkHttpClient,
    private val store: IPluginPerfStore,
) {

    suspend fun exec(action: String, data: String): MediaDetail {
        val mediaDetail = when (action) {

            ACTION_QRCODE_LOGIN -> {
                qrCodeLogin()
            }

            ACTION_QRCODE_LOGIN_POLL -> {
                checkQrCodeLogin(data = LenientJson.decodeFromString(data))
            }

            ACTION_LOGOUT -> throw RuntimeException("你已登录")

            ACTION_INVALID -> throw RuntimeException("这是一个动作卡片,请删除")

            else -> throw RuntimeException("未知动作")
        }
        return mediaDetail
    }

    private suspend fun qrCodeLogin(): MediaDetail {
        val resp = passportService.qrcodeGenerate()
        if (resp.code != 0L || resp.data == null) {
            throw RuntimeException(resp.message)
        }
        // NOTE: 这里用草料二维码转了一个二维码图片直链 泄露了key,如果被提前poll有泄露Cookie的风险
        val body = "https://api.cl2wm.cn/api/qrcode/code".toHttpUrl().newBuilder()
            .addQueryParameter("text", resp.data.url)
            .build()
            .toString()
            .toRequestBuild()
            .feignChrome()
            .get(okHttpClient = okHttpClient)
            .parseHtml()
            .body()
        val qrCodeUrl =
            body.selectFirst(".qrcode_plugins_box .qrcode_plugins_box_body #qrcode_plugins_img")
                ?.attr("src")
                ?.let { if (it.startsWith("//")) it.replaceFirst("//", "https://") else it }
                ?: throw RuntimeException("获取二维码直链地址失败")
        Timber.d("二维码地址: $qrCodeUrl")
        return createQrCodeLoginMediaDetail(
            title = "请扫描下方二维码后点击二维码",
            url = qrCodeUrl,
            key = resp.data.qrcodeKey,
        )
    }

    private suspend fun checkQrCodeLogin(data: QRCodeLoginCache): MediaDetail {
        val resp = passportService.qrcodePoll(qrcodeKey = data.key)
        if (resp.code != 0L || resp.data == null) {
            throw RuntimeException(resp.message)
        }
        return if (resp.data.code == 86038L) {
            qrCodeLogin()
        } else if (resp.data.code == 86090L) {
            createQrCodeLoginMediaDetail(
                title = "已扫码但是未确认,请手机确认后点击二维码",
                description = resp.data.message,
                url = data.url,
                key = data.key,
                flag = data.flag
            )
        } else if (resp.data.code == 0L) {
            store.update(BILI_REFRESH_TOKEN_KEY, resp.data.refreshToken)
            LOGIN_SUCCESS_MEDIA_DETAIL
        } else {
            createQrCodeLoginMediaDetail(
                title = "请扫描下方二维码后点击二维码",
                description = resp.data.message,
                url = data.url,
                key = data.key,
                flag = data.flag,
            )
        }
    }

    companion object {
        const val ACTION_PREFIX = "action_"
        const val ACTION_INVALID = "${ACTION_PREFIX}invalid"
        const val ACTION_QRCODE_LOGIN = "${ACTION_PREFIX}qrcode_login"
        const val ACTION_QRCODE_LOGIN_POLL = "${ACTION_PREFIX}qrcode_login_poll"
        const val ACTION_LOGOUT = "${ACTION_PREFIX}logout"

        val LOGIN_ACTION_CARD = MediaCard(
            id = ACTION_QRCODE_LOGIN,
            title = "未登录",
            subTitle = "点击去登录",
            detailUrl = ACTION_QRCODE_LOGIN,
        )

        val INVALID_ACTION_SAVED_MEDIA_CARD = SavedMediaCard(
            id = ACTION_INVALID,
            title = "无效的内容请删除",
            subTitle = "无效的内容请删除",
            detailUrl = ACTION_INVALID,
            coverImageUrl = "",
            cardWidth = BilibiliConst.AV_CARD_WIDTH,
            cardHeight = BilibiliConst.AV_CARD_HEIGHT,
        )

        val LOGIN_SUCCESS_MEDIA_DETAIL = MediaDetail(
            id = ACTION_QRCODE_LOGIN,
            title = "登录成功,请返回首页",
            detailUrl = ACTION_QRCODE_LOGIN,
            subTitle = null,
            backgroundImageUrl = "",
            description = "登录成功,请返回首页",
            playSourceList = listOf(),
            favoritedMediaCard = INVALID_ACTION_SAVED_MEDIA_CARD,
        )

        fun createLogoutCard(state: LoginState.Logged): MediaCard =
            MediaCard(
                id = ACTION_LOGOUT,
                title = state.uname,
                subTitle = "",
                detailUrl = ACTION_LOGOUT,
                coverImageUrl = state.face
            )

        fun createQrCodeLoginMediaDetail(
            title: String,
            description: String = title,
            url: String,
            key: String,
            flag: Int = 0,
        ): MediaDetail =
            MediaDetail(
                id = ACTION_QRCODE_LOGIN,
                title = title,
                detailUrl = ACTION_QRCODE_LOGIN,
                subTitle = null,
                backgroundImageUrl = url,
                description = description,
                playSourceList = listOf(),
                favoritedMediaCard = INVALID_ACTION_SAVED_MEDIA_CARD,
                rows = listOf(
                    MediaCardRow(
                        title = "登录动作",
                        list = listOf(
                            MediaCard(
                                id = ACTION_QRCODE_LOGIN_POLL,
                                title = "请扫描二维码后点击二维码",
                                detailUrl = LenientJson.encodeToString(
                                    QRCodeLoginCache(
                                        url = url,
                                        key = key,
                                        flag = flag + 1
                                    )
                                ),
                                coverImageUrl = url
                            ),
                        ),
                        cardWidth = BilibiliConst.QRCODE_CARD_WIDTH,
                        cardHeight = BilibiliConst.QRCODE_CARD_HEIGHT,
                    )
                )
            )

    }
}