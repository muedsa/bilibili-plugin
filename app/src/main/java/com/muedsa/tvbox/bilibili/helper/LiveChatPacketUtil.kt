package com.muedsa.tvbox.bilibili.helper

import okio.ByteString
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
import java.util.zip.Inflater

object LiveChatPacketUtil {

    val HEART_PACKET: ByteString = ByteString.of(0, 0, 0, 16, 0, 16, 0, 1, 0, 0, 0, 2, 0, 0, 0, 1)

    const val ROOM_AUTH_JSON = "{\"uid\":%d,\"roomid\":%d,\"protover\":2,\"platform\":\"web\",\"type\":2,\"key\":\"%s\"}"

    const val PROTOCOL_JSON = 0
    const val PROTOCOL_INT32 = 1
    const val PROTOCOL_ZIP = 2
    const val PROTOCOL_BROTLI = 3

    const val OPERATION_HEART = 2
    const val OPERATION_HOT = 3
    const val OPERATION_NOTIFY = 5
    const val OPERATION_AUTH = 7
    const val OPERATION_AUTH_SUCCESS = 8

    fun encode(content: String, protocolVersion: Int, operation: Int): ByteBuffer {
        val body = content.toByteArray(Charsets.UTF_8)
        val packet = ByteBuffer.allocate(16 + body.size)
        packet.putInt(16 + body.size)
        packet.putShort(16)
        packet.putShort(protocolVersion.toShort())
        packet.putInt(operation)
        packet.putInt(1)
        packet.put(body)
        packet.compact()
        return packet
    }

    fun decode(byteBuffer: ByteBuffer, msgList: MutableList<String> = mutableListOf()): List<String> {
        val packetLength = byteBuffer.getInt(0)
        val headerLength = byteBuffer.getShort(4)
        val protocolVersion = byteBuffer.getShort(6)
        // val operation = byteBuffer.getInt(8)
        // val sequenceId = byteBuffer.getInt(12)
        when (protocolVersion.toInt()) {
            PROTOCOL_JSON -> {
                byteBuffer.position(16)
                val dataByteBuffer = byteBuffer.slice()
                val charBuffer = Charsets.UTF_8.decode(dataByteBuffer)
                charBuffer.toString().split("[\\x00-\\x1f]+".toRegex()).forEach { msg ->
                    if (msg.length > 1) {
                        msgList.add(msg)
                    }
                }
            }
            PROTOCOL_ZIP -> {
                val input = ByteArray(packetLength - headerLength)
                byteBuffer.position(16)
                byteBuffer.get(input)
                val output = unZip(input)
                if (output.isNotEmpty()) {
                    val unzipByteBuffer = ByteBuffer.wrap(output)
                    decode(unzipByteBuffer, msgList)
                }
            }
            PROTOCOL_INT32, PROTOCOL_BROTLI -> {}
        }
        return msgList
    }

    fun unZip(input: ByteArray): ByteArray {
        return Inflater().run {
            setInput(input)
            ByteArrayOutputStream(input.size).use { outputStream ->
                try {
                    val buffer = ByteArray(1024)
                    while (!finished()) {
                        val count = inflate(buffer)
                        outputStream.write(buffer, 0, count)
                    }
                    outputStream.toByteArray()
                } catch (_: Throwable) {
                    ByteArray(0)
                } finally {
                    end()
                }
            }
        }
    }
}