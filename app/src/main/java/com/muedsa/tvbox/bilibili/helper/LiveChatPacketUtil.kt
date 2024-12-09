package com.muedsa.tvbox.bilibili.helper

import okio.ByteString
import org.brotli.dec.BrotliInputStream
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
import java.util.zip.Inflater

object LiveChatPacketUtil {

    val HEART_PACKET: ByteString = ByteString.of(
        0x00, 0x00, 0x00, 0x1f,
        0x00, 0x10,
        0x00, 0x01,
        0x00, 0x00, 0x00, 0x02,
        0x00, 0x00, 0x00, 0x01,
        // [object Object]
        0x5b, 0x6f, 0x62, 0x6a, 0x65, 0x63, 0x74, 0x20, 0x4f, 0x62, 0x6a, 0x65, 0x63, 0x74, 0x5d
    )

    // uid 登录用户id 未登录=0
    // roomid 直播间id
    // buvid cookie buvid3
    // key token
    const val ROOM_AUTH_JSON =
        "{\"uid\":%d,\"roomid\":%d,\"protover\":3,\"buvid\":\"%s\",\"platform\":\"web\",\"type\":2,\"key\":\"%s\"}"

    const val PROTOCOL_JSON = 0
    const val PROTOCOL_INT32 = 1
    const val PROTOCOL_ZIP = 2
    const val PROTOCOL_BROTLI = 3

    const val OPERATION_HEARTBEAT = 2
    const val OPERATION_HEARTBEAT_REPLY = 3
    const val OPERATION_CMD = 5
    const val OPERATION_AUTH = 7
    const val OPERATION_AUTH_REPLY = 8

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

    fun decode(byteBuffer: ByteBuffer): LiveChatPacket {
        val packetLength = byteBuffer.getInt()
        val headerLength = byteBuffer.getShort().toInt()
        val protocolVersion = byteBuffer.getShort().toInt()
        val operation = byteBuffer.getInt()
        val sequenceId = byteBuffer.getInt()
        val payload = ByteArray(packetLength - headerLength)
        byteBuffer.get(payload)
        if (protocolVersion == PROTOCOL_ZIP) {
            return decode(ByteBuffer.wrap(decompressZlibBytes(payload)))
        } else if (protocolVersion == PROTOCOL_BROTLI) {
            return decode(ByteBuffer.wrap(decompressBrotliBytes(payload)))
        }
        return LiveChatPacket(
            packetLength = packetLength,
            headerLength = headerLength,
            protocolVersion = protocolVersion,
            operation = operation,
            sequenceId = sequenceId,
            payload = payload,
        )
    }

    fun decompressZlibBytes(compressedData: ByteArray): ByteArray {
        val inflater = Inflater()
        return try {
            inflater.setInput(compressedData)
            val outputStream = ByteArrayOutputStream(compressedData.size)
            val buffer = ByteArray(1024)
            while (!inflater.finished()) {
                val count = inflater.inflate(buffer)
                outputStream.write(buffer, 0, count)
            }
            outputStream.toByteArray()
        } finally {
            inflater.end()
        }
    }

    fun decompressBrotliBytes(compressedBytes: ByteArray): ByteArray {
        return ByteArrayInputStream(compressedBytes).use { byteArrayIn ->
            BrotliInputStream(byteArrayIn).use { brotliIn ->
                ByteArrayOutputStream().use { byteArrayOut ->
                    brotliIn.copyTo(byteArrayOut)
                    byteArrayOut.toByteArray()
                }
            }
        }
    }

    val CMD_JSON_DELIMITER = "[\\x00-\\x1f]+".toRegex()

    fun decodeCMD(payload: ByteArray): List<String> {
        return String(payload, Charsets.UTF_8).split(CMD_JSON_DELIMITER).filter { it.isNotBlank() }
    }
}

data class LiveChatPacket(
    val packetLength: Int,
    val headerLength: Int,
    val protocolVersion: Int,
    val operation: Int,
    val sequenceId: Int,
    val payload: ByteArray,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LiveChatPacket

        if (packetLength != other.packetLength) return false
        if (headerLength != other.headerLength) return false
        if (protocolVersion != other.protocolVersion) return false
        if (operation != other.operation) return false
        if (sequenceId != other.sequenceId) return false
        if (!payload.contentEquals(other.payload)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = packetLength
        result = 31 * result + headerLength
        result = 31 * result + protocolVersion
        result = 31 * result + operation
        result = 31 * result + sequenceId
        result = 31 * result + payload.contentHashCode()
        return result
    }
}