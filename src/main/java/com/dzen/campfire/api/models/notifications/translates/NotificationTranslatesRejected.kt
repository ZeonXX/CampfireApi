package com.dzen.campfire.api.models.notifications.translates

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationTranslatesRejected: Notification {

    var adminName = ""
    var adminId = 0L
    var adminImageId = 0L
    var adminSex = 0L
    var comment = ""
    var key = ""

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_TRANSLATE_REJECTED

    constructor() {

    }

    constructor(
            adminName:String,
            adminId:Long,
            adminImageId:Long,
            adminSex:Long,
            comment:String,
            key:String,
    ) : super(adminImageId) {
        this.adminId = adminId
        this.adminName = adminName
        this.adminImageId = adminImageId
        this.adminSex = adminSex
        this.comment = comment
        this.key = key
    }

    override fun json(inp: Boolean, json: Json): Json {
        adminId = json.m(inp, "adminId", adminId)
        adminName = json.m(inp, "adminName", adminName)
        adminImageId = json.m(inp, "adminImageId", adminImageId)
        adminSex = json.m(inp, "adminSex", adminSex)
        comment = json.m(inp, "comment", comment)
        key = json.m(inp, "key", key)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
