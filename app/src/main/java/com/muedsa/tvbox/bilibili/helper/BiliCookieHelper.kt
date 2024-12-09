package com.muedsa.tvbox.bilibili.helper

import com.muedsa.tvbox.tool.SerializableCookie
import com.muedsa.tvbox.tool.SharedCookieSaver
import com.muedsa.tvbox.tool.decodeBase64
import java.security.KeyFactory
import java.security.spec.MGF1ParameterSpec
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher
import javax.crypto.spec.OAEPParameterSpec
import javax.crypto.spec.PSource

object BiliCookieHelper {

    const val COOKIE_UID = "DedeUserID"
    const val COOKIE_B_3 = "buvid3"
    const val COOKIE_B_4 = "buvid4"
    const val COOKIE_B_NUT = "b_nut"
    const val COOKIE_B_JCT = "bili_jct"
    const val COOKIE_B_TICKET = "bili_ticket"

    private val CORRESPOND_PATH_PUBLIC_KEY_BYTES = """
            -----BEGIN PUBLIC KEY-----
            MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDLgd2OAkcGVtoE3ThUREbio0Eg
            Uc/prcajMKXvkCKFCWhJYJcLkcM2DKKcSeFpD/j6Boy538YXnR6VhcuUJOhH2x71
            nzPjfdTcqMz7djHum0qSZA0AyCBDABUqCrfNgCiJ00Ra7GmRj+YCK1NJEuewlb40
            JNrRuoEUXpabUzGB8QIDAQAB
            -----END PUBLIC KEY-----
        """.trimIndent()
        .replace("-----BEGIN PUBLIC KEY-----", "")
        .replace("-----END PUBLIC KEY-----", "")
        .replace("\n", "")
        .trim()
        .decodeBase64()
    private val CORRESPOND_PATH_PUBLIC_KEY = KeyFactory.getInstance("RSA")
        .generatePublic(X509EncodedKeySpec(CORRESPOND_PATH_PUBLIC_KEY_BYTES))

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

    fun getCorrespondPath(timestamp: Long): String {
        val cipher = Cipher.getInstance("RSA/ECB/OAEPPadding").apply {
            init(
                Cipher.ENCRYPT_MODE,
                CORRESPOND_PATH_PUBLIC_KEY,
                OAEPParameterSpec(
                    "SHA-256",
                    "MGF1",
                    MGF1ParameterSpec.SHA256,
                    PSource.PSpecified.DEFAULT
                )
            )
        }
        return cipher.doFinal("refresh_$timestamp".toByteArray())
            .joinToString("") { "%02x".format(it) }
    }
}