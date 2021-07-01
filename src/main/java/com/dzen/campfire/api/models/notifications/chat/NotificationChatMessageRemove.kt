package com.dzen.campfire.api.models.notifications.chat

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationChatMessageRemove : Notification {

    var publicationId: Long = 0

    override fun isShadow() = true

    override fun isNeedForcePush() = false

    constructor() {

    }

    constructor(publicationId: Long) {
        this.publicationId = publicationId
    }

    override fun getType(): Long {
        return API.NOTIF_CHAT_MESSAGE_REMOVE
    }

    override fun json(inp: Boolean, json: Json): Json {
        publicationId = json.m(inp, "J_UNIT_ID", publicationId)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}

