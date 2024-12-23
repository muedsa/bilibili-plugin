package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.api.data.MediaCard
import com.muedsa.tvbox.api.data.MediaCardRow
import com.muedsa.tvbox.api.data.MediaCardType
import com.muedsa.tvbox.api.data.MediaDetail
import com.muedsa.tvbox.api.data.MediaHttpSource
import com.muedsa.tvbox.api.store.IPluginPerfStore
import com.muedsa.tvbox.bilibili.BILI_REFRESH_TOKEN_KEY
import com.muedsa.tvbox.bilibili.BILI_VIDEO_HEARTBEAT
import com.muedsa.tvbox.bilibili.BilibiliConst
import com.muedsa.tvbox.bilibili.helper.BiliCookieHelper
import com.muedsa.tvbox.bilibili.model.LoginState
import com.muedsa.tvbox.bilibili.model.QRCodeLoginCache
import com.muedsa.tvbox.bilibili.model.UserRelationModifyParams
import com.muedsa.tvbox.tool.LenientJson
import com.muedsa.tvbox.tool.SharedCookieSaver
import com.muedsa.tvbox.tool.feignChrome
import com.muedsa.tvbox.tool.get
import com.muedsa.tvbox.tool.parseHtml
import com.muedsa.tvbox.tool.toRequestBuild
import kotlinx.serialization.encodeToString
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import timber.log.Timber

class ActionDelegate(
    private val okHttpClient: OkHttpClient,
    private val passportService: BilibiliPassportService,
    private val apiService: BilibiliApiService,
    private val store: IPluginPerfStore,
    private val cookieSaver: SharedCookieSaver,
) {

    suspend fun exec(action: String, data: String): MediaDetail {
        val mediaDetail = when (action) {

            ACTION_QRCODE_LOGIN -> {
                qrCodeLogin()
            }

            ACTION_QRCODE_LOGIN_POLL -> {
                checkQrCodeLogin(data = LenientJson.decodeFromString(data))
            }

            ACTION_LOGOUT -> {
                loginExist()
            }

            ACTION_VIDEO_HEARTBEAT -> {
                val updateConfig = if (data.startsWith("$ACTION_VIDEO_HEARTBEAT:")) {
                    data.removePrefix("$ACTION_VIDEO_HEARTBEAT:").toIntOrNull()
                } else null
                videoHeartbeat(updateConfig = updateConfig)
            }

            ACTION_INVALID -> throw RuntimeException("这是一个动作卡片,请删除")

            else -> throw RuntimeException("未知动作")
        }
        return mediaDetail
    }

    suspend fun execAsGetEpisodePlayInfo(
        action: String,
        data: String?
    ): MediaHttpSource {
        val source = when (action) {
            ACTION_USER_FOLLOW -> {
                userRelationModify(
                    params = LenientJson.decodeFromString<UserRelationModifyParams>(
                        data ?: throw RuntimeException("参数错误")
                    )
                )
            }

            else -> throw RuntimeException("未知动作")
        }
        return source
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

    private suspend fun loginExist(): MediaDetail {
        val biliCSRF = BiliCookieHelper.getCookeValue(
            cookieSaver = cookieSaver,
            cookieName = BiliCookieHelper.COOKIE_B_JCT
        ) ?: throw RuntimeException("未登录")
        val resp = passportService.loginExitV2(biliCSRF = biliCSRF)
        if (resp.code == 0L) {
            throw RuntimeException("登录已注销，请重新进入插件")
        } else {
            throw RuntimeException("注销失败，${resp.message}")
        }
    }

    private suspend fun videoHeartbeat(updateConfig: Int? = null): MediaDetail {
        val config = if (updateConfig == 0 || updateConfig == 1 || updateConfig == 2) {
            store.update(key = BILI_VIDEO_HEARTBEAT, value = updateConfig)
            updateConfig
        } else {
            store.getOrDefault(key = BILI_VIDEO_HEARTBEAT, default = 0)
        }
        return createVideoHeartbeatMediaDetail(config)
    }

    private suspend fun userRelationModify(params: UserRelationModifyParams): MediaHttpSource {
        val resp = apiService.relationModify(
            fid = params.fid, act = params.act, csrf = BiliCookieHelper.getCookeValue(
                cookieSaver = cookieSaver,
                cookieName = BiliCookieHelper.COOKIE_B_JCT,
                defaultValue = null
            ) ?: throw RuntimeException("请登录后重试")
        )
        if (resp.code == 0L) {
            throw RuntimeException("关注成功")
        } else {
            throw RuntimeException(resp.message)
        }
    }

    companion object {
        const val ACTION_PREFIX = "action_"
        const val ACTION_INVALID = "${ACTION_PREFIX}invalid"
        const val ACTION_QRCODE_LOGIN = "${ACTION_PREFIX}qrcode_login"
        const val ACTION_QRCODE_LOGIN_POLL = "${ACTION_PREFIX}qrcode_login_poll"
        const val ACTION_LOGOUT = "${ACTION_PREFIX}logout"
        const val ACTION_VIDEO_HEARTBEAT = "${ACTION_PREFIX}_VIDEO_HEARTBEAT"
        const val ACTION_USER_FOLLOW = "${ACTION_PREFIX}_USER_FOLLOW"

        val LOGIN_ACTION_CARD = MediaCard(
            id = ACTION_QRCODE_LOGIN,
            title = "未登录",
            subTitle = "点击去登录",
            detailUrl = ACTION_QRCODE_LOGIN,
        )

        val INVALID_ACTION_SAVED_MEDIA_CARD = null

        val LOGIN_SUCCESS_MEDIA_DETAIL = MediaDetail(
            id = ACTION_QRCODE_LOGIN,
            title = "登录成功,请重新进入插件",
            detailUrl = ACTION_QRCODE_LOGIN,
            subTitle = null,
            backgroundImageUrl = "",
            description = "登录成功,请重新进入插件",
            playSourceList = listOf(),
            favoritedMediaCard = INVALID_ACTION_SAVED_MEDIA_CARD,
            disableEpisodeProgression = true,
        )

        fun createLogoutCard(state: LoginState.Logged): MediaCard =
            MediaCard(
                id = ACTION_LOGOUT,
                title = state.uname,
                subTitle = "注销登录",
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
                ),
                disableEpisodeProgression = true,
            )

        fun createVideoHeartbeatMediaDetail(config: Int): MediaDetail {
            val subTitle = when (config) {
                1 -> "已开启(上报开始播放)"
                2 -> "已开启(上报播放完成)"
                else -> "已关闭"
            }
            return MediaDetail(
                id = ACTION_VIDEO_HEARTBEAT,
                title = "播放进度上报",
                detailUrl = ACTION_VIDEO_HEARTBEAT,
                subTitle = subTitle,
                backgroundImageUrl = BilibiliConst.IMAGE_NO_SIGNAL,
                description = "开启后会在点击视频播放按钮时上报给Bilibili，使Bilibili可以记录播放历史。\n" +
                        "因为插件目前只能在点击按钮时上报一次（与实际播放与否、播放进度无关），所以目前只支持一次性上报播放进度为0(开始播放)或-1(播放完成)。",
                playSourceList = listOf(),
                favoritedMediaCard = INVALID_ACTION_SAVED_MEDIA_CARD,
                disableEpisodeProgression = true,
                rows = listOf(
                    MediaCardRow(
                        title = "登录动作",
                        list = listOf(
                            MediaCard(
                                id = ACTION_VIDEO_HEARTBEAT,
                                title = "${if (config == 0) "关闭" else "已关闭"}播放进度上报",
                                detailUrl = "$ACTION_VIDEO_HEARTBEAT:0",
                                backgroundColor = if (config == 0) 0xFF_05_B3_73 else 0x00_00_00_00,
                            ),
                            MediaCard(
                                id = ACTION_VIDEO_HEARTBEAT,
                                title = "${if (config == 1) "开启" else "已开启"}播放进度上报(开始播放)",
                                detailUrl = "$ACTION_VIDEO_HEARTBEAT:1",
                                backgroundColor = if (config == 1) 0xFF_05_B3_73 else 0x00_00_00_00,
                            ),
                            MediaCard(
                                id = ACTION_VIDEO_HEARTBEAT,
                                title = "${if (config == 2) "开启" else "已开启"}开启播放进度上报(播放完成)",
                                detailUrl = "$ACTION_VIDEO_HEARTBEAT:2",
                                backgroundColor = if (config == 2) 0xFF_05_B3_73 else 0x00_00_00_00,
                            )
                        ),
                        cardWidth = 240,
                        cardHeight = 60,
                        cardType = MediaCardType.NOT_IMAGE
                    )
                )
            )
        }

        val VIDEO_HEARTBEAT_ACTION_CARD = MediaCard(
            id = ACTION_VIDEO_HEARTBEAT,
            title = "视频进度上报",
            subTitle = "设置视频进度上报",
            detailUrl = ACTION_VIDEO_HEARTBEAT,
            coverImageUrl = "https://i0.hdslb.com/bfs/creative/23f832f985f4af14863a0a3d304f6fbfa0d61173.png@328w_185h.png"
        )
    }
}