package com.muedsa.tvbox.bilibili.helper

import com.muedsa.tvbox.tool.SerializableCookie
import com.muedsa.tvbox.tool.SharedCookieSaver

object BiliCookieHelper {

    const val COOKIE_UID = "DedeUserID"
    const val COOKIE_B_3 = "buvid3"
    const val COOKIE_B_4 = "buvid4"
    const val COOKIE_B_NUT = "b_nut"
    const val COOKIE_B_JCT = "bili_jct"
    const val COOKIE_B_TICKET = "bili_ticket"

    fun existCookie(cookieSaver: SharedCookieSaver, cookieName: String): Boolean =
        cookieSaver.load().any { it.name == cookieName }

    fun getCookeValue(
        cookieSaver: SharedCookieSaver,
        cookieName: String,
        defaultValue: String? = "",
    ) = cookieSaver.load().find { cookie -> cookie.name == cookieName }?.value ?: defaultValue

    fun createCookie(
        name: String,
        value: String,
        expiresAt: Long = System.currentTimeMillis() + 400L * 24L * 60L * 60L * 1000L,
        domain: String = "bilibili.com",
        path: String = "/",
        secure: Boolean = false,
        httpOnly: Boolean = false,
        persistent: Boolean = true,
        hostOnly: Boolean = true,
    ) : SerializableCookie = SerializableCookie(
        name = name,
        value = value,
        expiresAt = expiresAt,
        domain = domain,
        path = path,
        secure = secure,
        httpOnly = httpOnly,
        persistent = persistent,
        hostOnly = hostOnly,
    )
}