package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.api.data.MediaCard
import com.muedsa.tvbox.api.data.MediaCardRow
import com.muedsa.tvbox.api.data.MediaCardType
import com.muedsa.tvbox.api.service.IMainScreenService
import com.muedsa.tvbox.api.store.IPluginPerfStore
import com.muedsa.tvbox.bilibili.BILI_WBI_IMG_KEY
import com.muedsa.tvbox.bilibili.BILI_WBI_MIXIN_KEY
import com.muedsa.tvbox.bilibili.BILI_WBI_SUB_KEY
import com.muedsa.tvbox.bilibili.BilibiliConst
import com.muedsa.tvbox.bilibili.helper.BiliApiHelper
import com.muedsa.tvbox.bilibili.helper.BiliCookieHelper
import com.muedsa.tvbox.bilibili.model.BiliVideoDetailUrlAttrs
import com.muedsa.tvbox.bilibili.model.LoginState
import com.muedsa.tvbox.bilibili.model.bilibili.DynamicCard
import com.muedsa.tvbox.bilibili.model.bilibili.TopFeed
import com.muedsa.tvbox.tool.SharedCookieSaver
import com.muedsa.tvbox.tool.checkSuccess
import com.muedsa.tvbox.tool.feignChrome
import com.muedsa.tvbox.tool.get
import com.muedsa.tvbox.tool.toRequestBuild
import okhttp3.OkHttpClient

class MainScreenService(
    private val store: IPluginPerfStore,
    private val cookieSaver: SharedCookieSaver,
    private val okHttpClient: OkHttpClient,
    private val apiService: BilibiliApiService,
    private val passportService: BilibiliPassportService,
) : IMainScreenService {

    var loginState: LoginState = LoginState.NotLogin
    var mixinKey: String = ""

    override suspend fun getRowsData(): List<MediaCardRow> {
        checkLogin()
        val rows = mutableListOf<MediaCardRow>()
        // 推荐
        appendRecommendRow(rows = rows)
        // 动态
        appendDynamicRow(rows = rows)
        // 登录信息
        appendLoginInfoRow(rows = rows)
        return rows
    }

    private suspend fun appendRecommendRow(rows: MutableList<MediaCardRow>) {
        val uniqId = BiliApiHelper.generateFixedLengthRandomNumber(12)
        val list = mutableListOf<TopFeed>()
        loopLoadRecommend(uniqId = uniqId, index = 1, max = 3, list = list)
        if (list.isNotEmpty()) {
            rows.add(
                MediaCardRow(
                    title = "推荐视频",
                    list = list.filter { it.goto == "av" || it.goto == "live" }.mapNotNull {
                        if (it.goto == "av") {
                            MediaCard(
                                id = it.bvid,
                                detailUrl = BiliVideoDetailUrlAttrs(bvid = it.bvid).toJsonString(),
                                title = it.title,
                                subTitle = it.owner?.name ?: "",
                                coverImageUrl = it.pic
                            )
                        } else if (it.goto == "live") {
                            MediaCard(
                                id = "${MediaDetailService.MEDIA_ID_LIVE_ROOM_PREFIX}${it.id}",
                                detailUrl = BiliVideoDetailUrlAttrs(bvid = it.bvid).toJsonString(),
                                title = it.title,
                                subTitle = "直播 ${it.owner?.name ?: ""}",
                                coverImageUrl = it.pic
                            )
                        } else null
                    },
                    cardWidth = BilibiliConst.AV_CARD_WIDTH,
                    cardHeight = BilibiliConst.AV_CARD_HEIGHT,
                )
            )
        }
    }

    private suspend fun loopLoadRecommend(
        uniqId: String,
        index: Int,
        max: Int,
        list: MutableList<TopFeed>
    ) {
        if (index > max) return
        val resp = apiService.topFeedRcmd(
            BiliApiHelper.buildTopFeedRcmdParams(
                uniqId = uniqId,
                index = index,
                lastShowList = list.joinToString(",") {
                    "${it.goto}_${it.id}"
                },
                mixinKey = mixinKey
            )
        )
        if (resp.code == 0L && resp.data?.item?.isNotEmpty() == true) {
            list.addAll(resp.data.item)
        } else {
            return
        }
        loopLoadRecommend(uniqId = uniqId, index = index + 1, max = max, list = list)
    }

    private suspend fun appendDynamicRow(rows: MutableList<MediaCardRow>) {
        val list = mutableListOf<DynamicCard>()
        loopLoadDynamic(page = 1, maxPage = 5, offset = null, list = list)
        if (list.isNotEmpty()) {
            rows.add(
                MediaCardRow(
                    title = "视频动态",
                    list = list.filter { it.modules.moduleDynamic.major.type == "MAJOR_TYPE_ARCHIVE" }
                        .map {
                            val archive = it.modules.moduleDynamic.major.archive
                            MediaCard(
                                id = archive.bvid,
                                detailUrl = BiliVideoDetailUrlAttrs(bvid = archive.bvid).toJsonString(),
                                title = archive.title,
                                subTitle = it.modules.moduleAuthor.name,
                                coverImageUrl = archive.cover
                            )
                        },
                    cardWidth = BilibiliConst.AV_CARD_WIDTH,
                    cardHeight = BilibiliConst.AV_CARD_HEIGHT,
                )
            )
        }
    }

    private suspend fun loopLoadDynamic(
        page: Int,
        maxPage: Int,
        offset: Long? = null,
        list: MutableList<DynamicCard>
    ) {
        if (page > maxPage) return
        val resp = apiService.dynamicFeedAll(
            page = page,
            offset = offset
        )
        if (resp.code == 0L && resp.data?.items?.isNotEmpty() == true) {
            list.addAll(resp.data.items)
        } else {
            return
        }
        if (resp.data.hasMore) {
            loopLoadDynamic(
                page = page + 1,
                maxPage = maxPage,
                offset = resp.data.offset,
                list = list,
            )
        }
    }

    private suspend fun checkLogin() {
        // 先请求主页 可能会初始化一些cookie  buvid3 b_nut
        BilibiliConst.MAIN_SITE_URL.toRequestBuild()
            .feignChrome()
            .get(okHttpClient = okHttpClient)
            .checkSuccess()

        // buvid4
        if (cookieSaver.load().none { it.name == "buvid4"}) {
            val fingerSpiResp = apiService.fingerSpi()
            if (fingerSpiResp.code == 0L && fingerSpiResp.data != null) {
                if (fingerSpiResp.data.b3.isNotBlank()) {
                    cookieSaver.save(
                        BiliCookieHelper.createCookie(
                            name = "buvid3",
                            value = fingerSpiResp.data.b3
                        )
                    )
                }
                if (fingerSpiResp.data.b4.isNotBlank()) {
                    cookieSaver.save(
                        BiliCookieHelper.createCookie(
                            name = "buvid4",
                            value = fingerSpiResp.data.b4
                        )
                    )
                }
            }
        }

        // 检测登录并获取wbi
        val resp = apiService.nav()
        if ((resp.code == 0L || resp.code == -101L) && resp.data != null) {
            store.update(BILI_WBI_IMG_KEY, resp.data.wbiImg.imgKey)
            store.update(BILI_WBI_SUB_KEY, resp.data.wbiImg.subKey)
            store.update(BILI_WBI_MIXIN_KEY, resp.data.wbiImg.mixinKey)
            mixinKey = resp.data.wbiImg.mixinKey
            loginState = if (resp.data.isLogin) {
                LoginState.Logged(
                    mid = resp.data.mid,
                    uname = resp.data.uname,
                    face = resp.data.face,
                )
            } else {
                LoginState.NotLogin
            }
        } else {
            loginState = LoginState.NotLogin
        }

        // 检测是否需要刷新cookie 暂未实现
//        if (loginState is LoginState.Logged) {
//            BiliCookieHelper.getCookeValue(cookieSaver, "")
//            passportService.cookieInfo()
//        }
    }

    private fun appendLoginInfoRow(rows: MutableList<MediaCardRow>) {
        when (val s = loginState) {
            is LoginState.Logged -> {
                rows.add(
                    MediaCardRow(
                        title = "个人信息",
                        list = listOf(ActionDelegate.createLogoutCard(s)),
                        cardWidth = BilibiliConst.AVATAR_CARD_WIDTH,
                        cardHeight = BilibiliConst.AVATAR_CARD_HEIGHT,
                    )
                )
            }

            LoginState.NotLogin -> {
                rows.add(
                    MediaCardRow(
                        title = "个人信息",
                        list = listOf(ActionDelegate.LOGIN_ACTION_CARD),
                        cardWidth = BilibiliConst.BUTTON_CARD_WIDTH,
                        cardHeight = BilibiliConst.BUTTON_CARD_HEIGHT,
                        cardType = MediaCardType.NOT_IMAGE
                    )
                )
            }
        }
    }
}