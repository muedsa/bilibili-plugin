package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.api.data.MediaCard
import com.muedsa.tvbox.api.data.MediaCardRow
import com.muedsa.tvbox.api.data.MediaCardType
import com.muedsa.tvbox.api.service.IMainScreenService
import com.muedsa.tvbox.api.store.IPluginPerfStore
import com.muedsa.tvbox.bilibili.BILI_REFRESH_TOKEN_KEY
import com.muedsa.tvbox.bilibili.BILI_WBI_IMG_KEY
import com.muedsa.tvbox.bilibili.BILI_WBI_MIXIN_KEY
import com.muedsa.tvbox.bilibili.BILI_WBI_SUB_KEY
import com.muedsa.tvbox.bilibili.BilibiliConst
import com.muedsa.tvbox.bilibili.helper.BiliApiHelper
import com.muedsa.tvbox.bilibili.helper.BiliCookieHelper
import com.muedsa.tvbox.bilibili.model.BiliVideoDetailUrlAttrs
import com.muedsa.tvbox.bilibili.model.LoginState
import com.muedsa.tvbox.bilibili.model.bilibili.DynamicCard
import com.muedsa.tvbox.bilibili.model.bilibili.FollowingLiveUserInfo
import com.muedsa.tvbox.bilibili.model.bilibili.History
import com.muedsa.tvbox.bilibili.model.bilibili.PopularVideo
import com.muedsa.tvbox.bilibili.model.bilibili.TopFeed
import com.muedsa.tvbox.tool.SharedCookieSaver
import com.muedsa.tvbox.tool.checkSuccess
import com.muedsa.tvbox.tool.feignChrome
import com.muedsa.tvbox.tool.get
import com.muedsa.tvbox.tool.parseHtml
import com.muedsa.tvbox.tool.toRequestBuild
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import okhttp3.OkHttpClient
import timber.log.Timber

class MainScreenService(
    private val store: IPluginPerfStore,
    private val cookieSaver: SharedCookieSaver,
    private val okHttpClient: OkHttpClient,
    private val apiService: BilibiliApiService,
    private val liveApiService: BilibiliLiveApiService,
    private val passportService: BilibiliPassportService,
) : IMainScreenService {

    var loginState: LoginState = LoginState.NotLogin
    var mixinKey: String = ""

    override suspend fun getRowsData(): List<MediaCardRow> {
        checkLogin()
        return coroutineScope {
            listOf(
                async(Dispatchers.IO) { getPopularRow() },              // 热门
                async(Dispatchers.IO) { getRecommendRow() },            // 推荐
                async(Dispatchers.IO) { getDynamicRow() },              // 视频动态
                async(Dispatchers.IO) { getFollowingLiveUserRow() },    // 正在直播
                async(Dispatchers.IO) { getVideoHistoryRow() },         // 历史记录-视频
                async(Dispatchers.IO) { getLiveHistoryRow() },          // 历史记录-直播
                async(Dispatchers.IO) { getHistoryToViewRow() },        // 稍后再看
                async(Dispatchers.IO) { getLoginInfoRow() },            // 个人信息
            ).awaitAll().filterNotNull()
        }
    }

    private suspend fun getPopularRow(): MediaCardRow? {
        val list = mutableListOf<PopularVideo>()
        loopLoadPopular(list = list)
        return if (list.isNotEmpty()) {
            MediaCardRow(
                title = "热门视频",
                list = list.map {
                    MediaCard(
                        id = it.bvid,
                        detailUrl = BiliVideoDetailUrlAttrs(bvid = it.bvid).toJsonString(),
                        title = it.title,
                        subTitle = it.owner?.name ?: "",
                        coverImageUrl = it.pic
                    )
                },
                cardWidth = BilibiliConst.AV_CARD_WIDTH,
                cardHeight = BilibiliConst.AV_CARD_HEIGHT,
            )
        } else null
    }

    private suspend fun loopLoadPopular(
        page: Int = 1,
        maxPage: Int = 5,
        pageSize: Int = 20,
        list: MutableList<PopularVideo>
    ) {
        if (page > maxPage) return
        val resp = apiService.popular(
            params = BiliApiHelper.buildPopularParams(
                page = page,
                pageSize = pageSize,
                mixinKey = mixinKey
            )
        )
        if (resp.code != 0L || resp.data == null || resp.data.noMore || resp.data.list.isEmpty()) {
            return
        }
        list.addAll(resp.data.list)
        loopLoadPopular(page = page + 1, maxPage = maxPage, pageSize = pageSize, list = list)
    }

    private suspend fun getRecommendRow(): MediaCardRow? {
        val uniqId = BiliApiHelper.generateFixedLengthRandomNumber(12)
        val list = mutableListOf<TopFeed>()
        loopLoadRecommend(uniqId = uniqId, index = 1, max = 3, list = list)
        val avLiveList = list.filter { it.goto == "av" || it.goto == "live" }
        return if (avLiveList.isNotEmpty()) {
            MediaCardRow(
                title = "推荐视频",
                list = avLiveList.mapNotNull {
                    if (it.goto == "av") {
                        MediaCard(
                            id = it.bvid,
                            detailUrl = BiliVideoDetailUrlAttrs(bvid = it.bvid).toJsonString(),
                            title = it.title,
                            subTitle = it.owner?.name ?: "",
                            coverImageUrl = it.pic
                        )
                    } else if (it.goto == "live") {
                        val id = "${MediaDetailService.MEDIA_ID_LIVE_ROOM_PREFIX}${it.id}"
                        MediaCard(
                            id = id,
                            detailUrl = id,
                            title = it.title,
                            subTitle = "[直播]${it.owner?.name ?: ""}",
                            coverImageUrl = it.pic
                        )
                    } else null
                },
                cardWidth = BilibiliConst.AV_CARD_WIDTH,
                cardHeight = BilibiliConst.AV_CARD_HEIGHT,
            )
        } else null
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

    private suspend fun getDynamicRow(): MediaCardRow? {
        if (loginState !is LoginState.Logged) return null
        val list = mutableListOf<DynamicCard>()
        loopLoadDynamic(page = 1, maxPage = 5, offset = null, list = list)
        val archiveList =
            list.filter { it.modules.moduleDynamic.major.type == "MAJOR_TYPE_ARCHIVE" }
        return if (archiveList.isNotEmpty()) {
            MediaCardRow(
                title = "视频动态",
                list = archiveList.map {
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
        } else null
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

    private suspend fun getFollowingLiveUserRow(): MediaCardRow? {
        if (loginState !is LoginState.Logged) return null
        val list = mutableListOf<FollowingLiveUserInfo>()
        loopLoadFollowingLiveUser(list = list)
        return if (list.isNotEmpty()) {
            MediaCardRow(
                title = "正在直播",
                list = list.map {
                    val id = "${MediaDetailService.MEDIA_ID_LIVE_ROOM_PREFIX}${it.roomId}"
                    MediaCard(
                        id = id,
                        detailUrl = id,
                        title = it.title,
                        subTitle = "[直播]${it.uname}",
                        coverImageUrl = it.roomCover,
                    )
                },
                cardWidth = BilibiliConst.AV_CARD_WIDTH,
                cardHeight = BilibiliConst.AV_CARD_HEIGHT,
            )
        } else null
    }

    private suspend fun loopLoadFollowingLiveUser(
        page: Int = 1,
        maxPage: Int = -1,
        pageSize: Int = 29,
        list: MutableList<FollowingLiveUserInfo>
    ) {
        if (maxPage > 0 && page > maxPage) return
        val resp = liveApiService.userFollowing(page = page, pageSize = pageSize)
        if (resp.code == 0L) {
            val liveList = resp.data?.list?.filter { it.liveStatus == 1 }
            if (!liveList.isNullOrEmpty()) {
                list.addAll(liveList)
            }
        } else {
            return
        }
        val newMaxPage = if (maxPage <= 0) {
            val liveCount = resp.data?.liveCount ?: 0
            Timber.d("liveCount = $liveCount")
            if (liveCount > 0) {
                val size = resp.data?.pageSize ?: pageSize
                (liveCount / size) + (if (liveCount % size == 0) 0 else 1)
            } else 1
        } else maxPage
        loopLoadFollowingLiveUser(
            page = page + 1,
            maxPage = newMaxPage,
            pageSize = pageSize,
            list = list
        )
    }

    private suspend fun getVideoHistoryRow(): MediaCardRow? {
        if (loginState !is LoginState.Logged) return null
        val list = mutableListOf<History>()
        loopLoadHistory(num = 0, maxNum = 3, business = "archive", list = list)
        val archiveList = list.filter { it.history.business == "archive" }
        return if (archiveList.isNotEmpty()) {
            MediaCardRow(
                title = "历史记录-视频",
                list = archiveList.map {
                    MediaCard(
                        id = it.history.bvid,
                        detailUrl = BiliVideoDetailUrlAttrs(
                            bvid = it.history.bvid,
                            page = it.history.page
                        ).toJsonString(),
                        title = it.title,
                        subTitle = it.authorName,
                        coverImageUrl = it.cover,
                    )
                },
                cardWidth = BilibiliConst.AV_CARD_WIDTH,
                cardHeight = BilibiliConst.AV_CARD_HEIGHT,
            )
        } else null
    }

    private suspend fun getLiveHistoryRow(): MediaCardRow? {
        if (loginState !is LoginState.Logged) return null
        val list = mutableListOf<History>()
        loopLoadHistory(num = 0, maxNum = 3, business = "live", list = list)
        val liveList = list.filter { it.history.business == "live" }
        return if (liveList.isNotEmpty()) {
            MediaCardRow(
                title = "历史记录-直播",
                list = liveList.map {
                    val id = "${MediaDetailService.MEDIA_ID_LIVE_ROOM_PREFIX}${it.history.oid}"
                    MediaCard(
                        id = id,
                        detailUrl = id,
                        title = it.title,
                        subTitle = "[直播]${it.authorName}",
                        coverImageUrl = it.cover,
                    )
                },
                cardWidth = BilibiliConst.AV_CARD_WIDTH,
                cardHeight = BilibiliConst.AV_CARD_HEIGHT,
            )
        } else null
    }

    private suspend fun loopLoadHistory(
        num: Int = 0,
        maxNum: Int = 5,
        max: Long? = null,
        viewAt: Long? = null,
        business: String = "archive", // archive live
        ps: Int = 30,
        list: MutableList<History>
    ) {
        if (num > maxNum) return
        val resp =
            apiService.historyCursor(max = max, business = business, viewAt = viewAt, ps = ps)
        if (resp.code == 0L && resp.data?.list?.isNotEmpty() == true) {
            val historyCursorFlow = resp.data
            list.addAll(resp.data.list)
            loopLoadHistory(
                num = num + 1,
                maxNum = maxNum,
                max = historyCursorFlow.cursor.max,
                viewAt = historyCursorFlow.cursor.viewAt,
                ps = ps,
                list = list,
            )
        } else {
            return
        }
    }

    private suspend fun getHistoryToViewRow(): MediaCardRow? {
        if (loginState !is LoginState.Logged) return null
        val resp = apiService.historyToViewWeb()
        return if (resp.code == 0L&& resp.data != null && resp.data.list.isNotEmpty()) {
            MediaCardRow(
                title = "稍后再看",
                list = resp.data.list.map {
                    MediaCard(
                        id = it.bvid,
                        detailUrl = BiliVideoDetailUrlAttrs(bvid = it.bvid).toJsonString(),
                        title = it.title,
                        subTitle = it.owner?.name ?: "",
                        coverImageUrl = it.pic
                    )
                },
                cardWidth = BilibiliConst.AV_CARD_WIDTH,
                cardHeight = BilibiliConst.AV_CARD_HEIGHT,
            )
        } else null
    }

    private suspend fun checkLogin() {
        // 先请求主页 可能会初始化一些cookie  buvid3 b_nut
        BilibiliConst.MAIN_SITE_URL.toRequestBuild()
            .feignChrome()
            .get(okHttpClient = okHttpClient)
            .checkSuccess()

        // buvid4
        if (!BiliCookieHelper.existCookie(
                cookieSaver = cookieSaver,
                cookieName = BiliCookieHelper.COOKIE_B_4
            )
        ) {
            val fingerSpiResp = apiService.fingerSpi()
            if (fingerSpiResp.code == 0L && fingerSpiResp.data != null) {
                if (fingerSpiResp.data.b3.isNotBlank()) {
                    cookieSaver.save(
                        BiliCookieHelper.createCookie(
                            name = BiliCookieHelper.COOKIE_B_3,
                            value = fingerSpiResp.data.b3
                        )
                    )
                }
                if (fingerSpiResp.data.b4.isNotBlank()) {
                    cookieSaver.save(
                        BiliCookieHelper.createCookie(
                            name = BiliCookieHelper.COOKIE_B_4,
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

        // 检测是否需要刷新cookie
        if (loginState is LoginState.Logged) {
            try {
                val oldRefreshToken = store.get(BILI_REFRESH_TOKEN_KEY)
                val oldCsrf = BiliCookieHelper.getCookeValue(
                    cookieSaver = cookieSaver,
                    cookieName = BiliCookieHelper.COOKIE_B_JCT
                )
                if (!oldRefreshToken.isNullOrEmpty() && !oldCsrf.isNullOrEmpty()) {
                    val resp = passportService.cookieInfo(csrf = oldCsrf)
                    if (resp.code == 0L && resp.data != null && resp.data.refresh) {
                        // 需要刷新Cookie
                        val body =
                            "${BilibiliConst.REFRESH_CSRF_URL}${
                                BiliCookieHelper.getCorrespondPath(
                                    resp.data.timestamp
                                )
                            }"
                                .toRequestBuild()
                                .feignChrome()
                                .get(okHttpClient = okHttpClient)
                                .parseHtml()
                                .body()
                        body.selectFirst("#1-name")?.text()?.trim()?.let { refreshCsrf ->
                            val resp = passportService.cookieRefresh(
                                csrf = oldCsrf,
                                refreshCsrf = refreshCsrf,
                                source = "main_web",
                                refreshToken = oldRefreshToken
                            )
                            if (resp.code == 0L && resp.data != null && resp.data.refreshToken.isNotEmpty()) {
                                store.update(BILI_REFRESH_TOKEN_KEY, resp.data.refreshToken)
                                BiliCookieHelper.getCookeValue(
                                    cookieSaver = cookieSaver,
                                    cookieName = BiliCookieHelper.COOKIE_B_JCT
                                )?.let { newCsrf ->
                                    passportService.confirmRefresh(
                                        csrf = newCsrf,
                                        refreshToken = oldRefreshToken
                                    )
                                }
                            }
                        }
                    } else {
                        Timber.d("no need to refresh cookie")
                    }
                }
            } catch (throwable: Throwable) {
                Timber.e(throwable, "refresh cookie error")
            }
        }

        // bili_ticket
        if (!BiliCookieHelper.existCookie(
                cookieSaver = cookieSaver,
                cookieName = BiliCookieHelper.COOKIE_B_TICKET
            )
        ) {
            val genWebTicketResp = apiService.genWebTicket(
                csrf = BiliCookieHelper.getCookeValue(
                    cookieSaver = cookieSaver,
                    cookieName = BiliCookieHelper.COOKIE_B_JCT,
                    defaultValue = null
                )
            )
            if (genWebTicketResp.code == 0L && genWebTicketResp.data != null) {
                val ticket = genWebTicketResp.data.ticket
                val exportsAt = (genWebTicketResp.data.createdAt + genWebTicketResp.data.ttl) * 1000L
                if (ticket.isNotBlank() && exportsAt > 0L) {
                    cookieSaver.save(
                        BiliCookieHelper.createCookie(
                            name = BiliCookieHelper.COOKIE_B_TICKET,
                            value = ticket,
                            expiresAt = exportsAt
                        )
                    )
                }

            }
        }
    }

    private fun getLoginInfoRow(): MediaCardRow {
        return when (val s = loginState) {
            is LoginState.Logged -> {
                MediaCardRow(
                    title = "个人信息",
                    list = listOf(
                        ActionDelegate.createLogoutCard(s),
                        ActionDelegate.VIDEO_HEARTBEAT_ACTION_CARD,
                    ),
                    cardWidth = BilibiliConst.AVATAR_CARD_WIDTH,
                    cardHeight = BilibiliConst.AVATAR_CARD_HEIGHT,
                )
            }
            LoginState.NotLogin -> {
                MediaCardRow(
                    title = "个人信息",
                    list = listOf(ActionDelegate.LOGIN_ACTION_CARD),
                    cardWidth = BilibiliConst.BUTTON_CARD_WIDTH,
                    cardHeight = BilibiliConst.BUTTON_CARD_HEIGHT,
                    cardType = MediaCardType.NOT_IMAGE
                )
            }
        }
    }
}