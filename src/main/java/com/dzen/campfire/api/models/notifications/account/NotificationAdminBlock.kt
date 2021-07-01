package com.dzen.campfire.api.models.notifications.account

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationAdminBlock : Notification {

    var blockAccountDate = 0L
    var comment = ""

    constructor()

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_BLOCK

    constructor(blockAccountDate: Long, comment: String) : super(0) {
        this.blockAccountDate = blockAccountDate
        this.comment = comment
    }

    override fun json(inp: Boolean, json: Json): Json {
        blockAccountDate = json.m(inp,  "J_BLOCK_ACCOUNT_DATE", blockAccountDate)
        comment = json.m(inp, "J_COMMENT", comment)
        return super.json(inp, json)
    }


    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}