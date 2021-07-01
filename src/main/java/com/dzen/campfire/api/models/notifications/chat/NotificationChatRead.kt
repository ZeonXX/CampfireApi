package com.dzen.campfire.api.models.notifications.chat


import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.chat.ChatTag
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json


class NotificationChatRead : Notification {

    var tag = ChatTag()
    var date = 0L

    override fun isShadow() = true

    override fun isNeedForcePush() = false

    override fun getType() = API.NOTIF_CHAT_READ

    constructor()

    constructor(tag: ChatTag, date: Long) : super(0) {
        this.tag = tag
        this.date = date
    }

    override fun json(inp: Boolean, json: Json): Json {
        tag = json.m(inp, "tag", tag, ChatTag::class)
        date = json.m(inp, "date", date)
        return super.json(inp, json)
    }



    override fun fillResourcesList(list: ArrayList<Long>) {

    }


}
