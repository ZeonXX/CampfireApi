package com.dzen.campfire.api.models.notifications.translates

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationTranslatesAccepted: Notification {

    var key = ""

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_TRANSLATE_ACCEPTED

    constructor() {

    }
    constructor(key:String) {
        this.key = key
    }

    override fun json(inp: Boolean, json: Json): Json {
        key = json.m(inp, "key", key)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
