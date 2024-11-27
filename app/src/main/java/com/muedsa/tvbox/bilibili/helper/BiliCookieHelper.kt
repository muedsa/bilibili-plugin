package com.muedsa.tvbox.bilibili.helper

import com.muedsa.tvbox.tool.SerializableCookie
import com.muedsa.tvbox.tool.SharedCookieSaver

object BiliCookieHelper {

    fun getCookeValue(
        cookieSaver: SharedCookieSaver,
        cookieName: String,
        defaultValue: String = "",
    ) = cookieSaver.load().find { cookie -> cookie.name == cookieName }?.value ?: defaultValue

    fun createCookie(
        name: String,
        value: String,
        expiresAt: Long = System.currentTimeMillis() + 365 * 24 * 60 * 60 * 100,
        domain: String = ".bilibili.com",
        path: String = "/",
        secure: Boolean = false,
        httpOnly: Boolean = false,
        persistent: Boolean = true,
        hostOnly: Boolean = false,
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