package com.dzen.campfire.api.models.notifications.project

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationDonate: Notification {

    var sum = 0L

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_DONATE

    constructor() {

    }

    constructor(sum: Long) : super(0) {
        this.sum = sum
    }

    override fun json(inp: Boolean, json: Json): Json {
        sum = json.m(inp, "sum", sum)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
