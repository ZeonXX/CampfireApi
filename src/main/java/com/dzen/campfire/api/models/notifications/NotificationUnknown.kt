package com.dzen.campfire.api.models.notifications

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class NotificationUnknown : Notification {

    override fun isShadow() = true

    override fun isNeedForcePush() = false

    override fun getType() = API.NOTIF_UNKNOWN

    constructor() {

    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}
