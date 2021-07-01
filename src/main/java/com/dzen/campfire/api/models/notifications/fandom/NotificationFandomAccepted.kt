package com.dzen.campfire.api.models.notifications.fandom

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationFandomAccepted : Notification {

    var fandomId = 0L
    var fandomName = ""
    var accepted = false
    var comment = ""
    var accountId = 0L
    var adminName = ""

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    constructor() {

    }

    constructor(accountId: Long, fandomImageId: Long, fandomId: Long, fandomName: String, accepted: Boolean, comment: String, adminName: String) : super(fandomImageId) {
        this.fandomId = fandomId
        this.accountId = accountId
        this.fandomName = fandomName
        this.accepted = accepted
        this.comment = comment
        this.adminName = adminName
    }

    override fun json(inp: Boolean, json: Json): Json {
        fandomId = json.m(inp, "fandomId", fandomId)
        accountId = json.m(inp, "accountId", accountId)
        fandomName = json.m(inp, "fandomName", fandomName)
        accepted = json.m(inp, "accepted", accepted)
        comment = json.m(inp, "comment", comment)
        adminName = json.m(inp, "adminName", adminName)
        return super.json(inp, json)
    }

    override fun getType(): Long {
        return API.NOTIF_FANDOM_ACCPTED
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}
