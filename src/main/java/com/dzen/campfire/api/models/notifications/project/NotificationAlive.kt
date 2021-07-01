package com.dzen.campfire.api.models.notifications.project

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationAlive: Notification {

    override fun isShadow() = true

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_ALIVE

    constructor() : super(0) {
    }

    override fun json(inp: Boolean, json: Json): Json {
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
