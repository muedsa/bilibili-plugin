package com.muedsa.tvbox.bilibili.service

import com.muedsa.tvbox.api.data.DanmakuData
import com.muedsa.tvbox.api.data.DanmakuDataFlow
import com.muedsa.tvbox.bilibili.BilibiliConst.CMD_DANMU_MSG
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

class LiveDanmakuDataFlow(
    private val uid: Long,
    private val roomId: Long,
    private val token: String,
    private val request: Request,
    okHttpClient: OkHttpClient,
) : DanmakuDataFlow {

    override val flow = MutableSharedFlow<DanmakuData>()

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val listener = object : WebSocketListener() {
        override fun onOpen(webSocket: WebSocket, response: Response) {
            val joinRoomJson =
                String.format(Locale.CHINA, LiveChatPacketUtil.ROOM_AUTH_JSON, uid, roomId, token)
            webSocket.send(
                LiveChatPacketUtil.encode(joinRoomJson, 1, LiveChatPacketUtil.OPERATION_AUTH)
                    .toByteString()
            )
            loop()
            Timber.d("live room $roomId WebSocket opened")
        }

        override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
            val byteBuffer = bytes.asByteBuffer()
            val msgList = LiveChatPacketUtil.decode(byteBuffer)
            msgList.forEach { msg ->
                val jsonElement = LenientJson.parseToJsonElement(msg)
                val cmd = jsonElement.jsonObject["cmd"]?.jsonPrimitive?.content
                when (cmd) {
                    CMD_DANMU_MSG -> {
                        // Timber.d(jsonElement.toString())
                        val infoJsonArr = jsonElement.jsonObject["info"]?.jsonArray
                        if (!infoJsonArr.isNullOrEmpty()) {
                            val propertyJsonArr = infoJsonArr[0].jsonArray
                            val mode = propertyJsonArr[1].jsonPrimitive.int
                            val textColor =
                                (propertyJsonArr[3].jsonPrimitive.long xor 0x00000000ff000000L).toInt()
                            val text = infoJsonArr[1].jsonPrimitive.content
                            val m: Int? = when (mode) {
                                1, 2, 3 -> 1
                                4 -> 4
                                5 -> 5
                                else -> null
                            }
                            m?.let {
                                coroutineScope.launch {
                                    flow.emit(
                                        DanmakuData(
                                            danmakuId = Random.nextLong(),
                                            position = -1,
                                            content = text,
                                            textColor = textColor,
                                            mode = it,
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            Timber.e(t, response?.message)
        }

        override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
            closed = true
            Timber.d("live room $roomId WebSocket closed")
        }
    }

    private val webSocket = okHttpClient.newWebSocket(request = request, listener = listener)

    private var closed: Boolean = false

    fun loop() {
        coroutineScope.launch {
            delay(30.seconds)
            while (!closed) {
                webSocket.send(bytes = LiveChatPacketUtil.HEART_PACKET)
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
}