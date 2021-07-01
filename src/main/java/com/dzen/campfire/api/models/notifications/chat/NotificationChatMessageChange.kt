package com.dzen.campfire.api.models.notifications.chat

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json


class NotificationChatMessageChange : Notification {

    var publicationId: Long = 0
    var text: String = ""

    override fun isShadow() = true

    override fun isNeedForcePush() = false

    override fun getType() = API.NOTIF_CHAT_MESSAGE_CHANGE

    constructor() {

    }

    constructor(publicationId: Long, text: String) {
        this.publicationId = publicationId
        this.text = text
    }

    override fun json(inp: Boolean, json: Json): Json {
        publicationId = json.m(inp, "J_UNIT_ID", publicationId)
        text = json.m(inp, "J_TEXT", text)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
