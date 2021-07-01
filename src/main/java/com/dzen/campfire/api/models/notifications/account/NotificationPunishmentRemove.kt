package com.dzen.campfire.api.models.notifications.account

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationPunishmentRemove : Notification {

    var fromAccountId = 0L
    var fromAccountName = ""
    var fromAccountSex = 0L
    var comment = ""

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_PUNISHMENT_REMOVE
    constructor()

    constructor(fromAccountId: Long,
                fromAccountImageId: Long,
                fromAccountName: String,
                fromAccountSex: Long,
                comment:String) : super(fromAccountImageId) {
        this.fromAccountId = fromAccountId
        this.fromAccountName = fromAccountName
        this.fromAccountSex = fromAccountSex
        this.comment = comment
    }

    override fun json(inp: Boolean, json: Json): Json {
        fromAccountId = json.m(inp, "fromAccountId", fromAccountId)
        fromAccountName = json.m(inp, "fromAccountName", fromAccountName)
        fromAccountSex = json.m(inp, "fromAccountSex", fromAccountSex)
        comment = json.m(inp, "comment", comment)
        return super.json(inp, json)
    }


    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
