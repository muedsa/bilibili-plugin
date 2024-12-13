package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.api.data.DanmakuData
import com.muedsa.tvbox.api.data.DanmakuDataFlow
import com.muedsa.tvbox.bilibili.BilibiliConst
import com.muedsa.tvbox.bilibili.helper.LiveChatPacketUtil
import com.muedsa.tvbox.tool.LenientJson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.long
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import okio.ByteString.Companion.toByteString
import timber.log.Timber
import java.util.Locale
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalStdlibApi::class)
class LiveDanmakuDataFlow(
    private val uid: Long,
    private val roomId: Long,
    private val b3: String,
    private val token: String,
    private val request: Request,
    okHttpClient: OkHttpClient,
    val debug: Boolean = false,
) : DanmakuDataFlow {

    override val flow = MutableSharedFlow<DanmakuData>()

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val combineDanmakuNumCache = mutableMapOf<Long, Int>()

    private val listener = object : WebSocketListener() {
        override fun onOpen(webSocket: WebSocket, response: Response) {
            val joinRoomJson =
                String.format(
                    Locale.CHINA,
                    LiveChatPacketUtil.ROOM_AUTH_JSON,
                    uid,
                    roomId,
                    b3,
                    token
                )
            webSocket.send(
                LiveChatPacketUtil.encode(joinRoomJson, 1, LiveChatPacketUtil.OPERATION_AUTH)
                    .toByteString()
            )
            loop()
            Timber.d("live room $roomId WebSocket opened")
        }

        override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
            coroutineScope.launch {
                try {
                    val byteBuffer = bytes.asByteBuffer()
                    val packet = LiveChatPacketUtil.decode(byteBuffer)
                    when (packet.protocolVersion) {
                        LiveChatPacketUtil.PROTOCOL_JSON -> {
                            when (packet.operation) {
                                LiveChatPacketUtil.OPERATION_CMD -> {
                                    val cmdMsgList =
                                        LiveChatPacketUtil.decodeCMD(payload = packet.payload)
                                    cmdMsgList.forEach { cmdMsg ->
                                        if (debug) {
                                            Timber.i("cmdMsg = $cmdMsg")
                                        }
                                        val jsonElement = LenientJson.parseToJsonElement(cmdMsg)
                                        var cmd =
                                            jsonElement.jsonObject["cmd"]?.jsonPrimitive?.content
                                        if (cmd?.contains(":") == true) {
                                            cmd = cmd.split(":")[0]
                                        }
                                        val danmakuList: List<DanmakuData>? = when (cmd) {
                                            BilibiliConst.CMD_DANMU_MSG -> {
                                                val infoJsonArr =
                                                    jsonElement.jsonObject["info"]?.jsonArray
                                                if (!infoJsonArr.isNullOrEmpty()) {
                                                    val propertyJsonArr = infoJsonArr[0].jsonArray
                                                    val mode = propertyJsonArr[1].jsonPrimitive.int
                                                    val textColor =
                                                        (propertyJsonArr[3].jsonPrimitive.long
                                                                xor 0x00000000ff000000L).toInt()
                                                    val text = infoJsonArr[1].jsonPrimitive.content
                                                    val m: Int? = when (mode) {
                                                        1, 2, 3 -> 1
                                                        4 -> 4
                                                        5 -> 5
                                                        else -> null
                                                    }
                                                    m?.let {
                                                        listOf(
                                                            DanmakuData(
                                                                danmakuId = Random.nextLong(),
                                                                position = -1,
                                                                content = text,
                                                                textColor = textColor,
                                                                mode = it,
                                                            )
                                                        )
                                                    }
                                                } else null
                                            }

                                            BilibiliConst.CMD_SUPER_CHAT_MESSAGE -> {
                                                val dataJsonObject =
                                                    jsonElement.jsonObject["data"]?.jsonObject
                                                if (!dataJsonObject.isNullOrEmpty()) {
                                                    val price =
                                                        dataJsonObject["price"]!!.jsonPrimitive
                                                            .content
                                                    val message =
                                                        dataJsonObject["message"]!!.jsonPrimitive
                                                            .content
                                                    val messageFontColor =
                                                        dataJsonObject["message_font_color"]!!
                                                            .jsonPrimitive
                                                            .content
                                                            .removePrefix("#")
                                                            .hexToInt()
                                                    listOf(
                                                        DanmakuData(
                                                            danmakuId = dataJsonObject["id"]!!
                                                                .jsonPrimitive
                                                                .long,
                                                            position = -1,
                                                            content = "[SC-$price￥]$message",
                                                            textColor = messageFontColor,
                                                            mode = 4,
                                                        )
                                                    )
                                                }
                                                null
                                            }

                                            BilibiliConst.CMD_DM_INTERACTION -> {
                                                val type = jsonElement.jsonObject["data"]!!
                                                    .jsonObject["type"]!!
                                                    .jsonPrimitive
                                                    .int
                                                val jsonObject = LenientJson.parseToJsonElement(
                                                    jsonElement.jsonObject["data"]!!
                                                        .jsonObject["data"]!!
                                                        .jsonPrimitive
                                                        .content
                                                ).jsonObject
                                                when (type) {
                                                    102 -> {
                                                        if (jsonObject.containsKey("combo")) {
                                                            jsonObject["combo"]!!.jsonArray.map {
                                                                val id =
                                                                    it.jsonObject["id"]!!.jsonPrimitive.long
                                                                val sendCnt =
                                                                    combineDanmakuNumCache[id] ?: 0
                                                                val cnt =
                                                                    it.jsonObject["cnt"]!!.jsonPrimitive.int
                                                                if (cnt > sendCnt) {
                                                                    combineDanmakuNumCache[id] = cnt
                                                                    buildList {
                                                                        for (i in 0 until (cnt - sendCnt)) {
                                                                            add(
                                                                                DanmakuData(
                                                                                    danmakuId = Random.nextLong(),
                                                                                    position = -1,
                                                                                    content = it.jsonObject["content"]!!
                                                                                        .jsonPrimitive
                                                                                        .content,
                                                                                    mode = 1
                                                                                )
                                                                            )
                                                                        }
                                                                    }
                                                                } else emptyList<DanmakuData>()
                                                            }.flatMap { it }
                                                        } else null
                                                    }

                                                    else -> null
                                                }
                                            }

                                            else -> null
                                        }
                                        danmakuList?.let {
                                            it.forEach { m ->
                                                coroutineScope.launch {
                                                    flow.emit(
                                                        m
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                                else -> {
                                    if (debug) {
                                        Timber.i("$packet")
                                    }
                                }
                            }
                        }

                        LiveChatPacketUtil.PROTOCOL_INT32 -> {
                            when (packet.operation) {
                                LiveChatPacketUtil.OPERATION_AUTH_REPLY -> {}
                                else -> {
                                    if (debug) {
                                        Timber.i("$packet")
                                    }
                                }
                            }
                        }

                        else -> {
                            if (debug) {
                                Timber.i("$packet")
                            }
                        }
                    }
                } catch (throwable: Throwable) {
                    Timber.e(throwable, "$bytes")
                }
            }
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            Timber.e(t, response?.message)
            flow.tryEmit(
                DanmakuData(
                    danmakuId = Random.nextLong(),
                    position = -1,
                    content = "弹幕流意外断开, ${t.message}",
                    textColor = 0xFF_00_00,
                    mode = 4,
                )
            )
        }

        override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
            closed = true
            Timber.d("live room $roomId WebSocket closed")
            flow.tryEmit(
                DanmakuData(
                    danmakuId = Random.nextLong(),
                    position = -1,
                    content = "弹幕流断开",
                    textColor = 0xFF_00_00,
                    mode = 4,
                )
            )
        }
    }

    private val webSocket = okHttpClient.newWebSocket(request = request, listener = listener)

    private var closed: Boolean = false

    fun loop() {
        coroutineScope.launch {
            while (!closed) {
                webSocket.send(bytes = LiveChatPacketUtil.HEART_PACKET)
                delay(HEARTBEAT_DELAY)
            }
        }
    }

    override fun close() {
        if (!closed) {
            Timber.d("live room $roomId WebSocket request close")
            webSocket.close(code = 1001, reason = null)
            closed = true
        }
    }

    companion object {
        val HEARTBEAT_DELAY = 30.seconds
    }

}