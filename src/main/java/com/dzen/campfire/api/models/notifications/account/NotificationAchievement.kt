package com.dzen.campfire.api.models.notifications.account

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json


class NotificationAchievement : Notification {

    var achiIndex: Long = 0
    var achiLvl: Int = 0

    constructor() {

    }

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    constructor(achiIndex: Long, achiLvl: Int) : super(0) {
        this.achiIndex = achiIndex
        this.achiLvl = achiLvl
    }

    override fun json(inp: Boolean, json: Json): Json {
        achiIndex = json.m(inp, "J_ACHI_INDEX", achiIndex)
        achiLvl = json.m(inp, "J_ACHI_LVL", achiLvl)
        return super.json(inp, json)
    }

    override fun getType(): Long {
        return API.NOTIF_ACHI
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
