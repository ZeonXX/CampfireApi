package com.dzen.campfire.api.models.notifications.chat

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.chat.ChatTag
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json


class NotificationChatTyping : Notification {

    var chatTag = ChatTag()
    var accountId: Long = 0
    var accountImageId: Long = 0
    var accountName: String = ""

    override fun isShadow() = true

    override fun isNeedForcePush() = false

    constructor() {

    }

    constructor(chatTag: ChatTag, accountId: Long, accountName: String, accountImageId: Long) {
        this.chatTag = chatTag
        this.accountId = accountId
        this.accountName = accountName
        this.accountImageId = accountImageId
    }

    override fun getType(): Long {
        return API.NOTIF_CHAT_TYPING
    }

    override fun json(inp: Boolean, json: Json): Json {
        chatTag = json.m(inp, "chatTag", chatTag, ChatTag::class)
        accountId = json.m(inp, "accountId", accountId)
        accountName = json.m(inp, "accountName", accountName)
        accountImageId = json.m(inp, "accountImageId", accountImageId)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}