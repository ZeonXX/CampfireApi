package com.dzen.campfire.api.models.chat

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class ChatTag(
        var chatType: Long = 0,
        var targetId: Long = 0,
        var targetSubId: Long = 0
) : JsonParsable {

    private var accountId = 0L

    init {
        if (chatType == API.CHAT_TYPE_PRIVATE) {
            if (targetId < targetSubId) {
                val x = targetId
                targetId = targetSubId
                targetSubId = x
            }
        }
    }

    constructor(tag: String) : this() {
        val split = tag.split("-")
        this.chatType = split[0].toLong()
        this.targetId = split[1].toLong()
        this.targetSubId = split[2].toLong()
    }

    override fun json(inp: Boolean, json: Json): Json {
        chatType = json.m(inp, "chatType", chatType)
        targetId = json.m(inp, "targetId", targetId)
        targetSubId = json.m(inp, "targetSubId", targetSubId)
        return json
    }

    fun setMyAccountId(accountId: Long) {
        this.accountId = accountId
    }

    fun getAnotherId(): Long {
        return if (targetId == accountId) targetSubId else targetId
    }

    override fun equals(other: Any?): Boolean {
        return other is ChatTag && other.chatType == chatType && other.targetId == targetId && other.targetSubId == targetSubId
    }

    fun asTag() = "$chatType-$targetId-$targetSubId"

    override fun hashCode() = asTag().hashCode()

    override fun toString() = asTag()

}