package com.dzen.campfire.api.models.notifications.account

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.account.MAccountEffect
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationEffectRemove : Notification {

    var effectId = 0L
    var effectIndex = 0L
    var comment = ""
    var adminName = ""
    var adminSex = 0L

    constructor()

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_EFFECT_REMOVE

    constructor(effectId: Long, effectIndex: Long, comment:String, adminName:String, adminSex:Long, adminImageId: Long) : super(adminImageId) {
        this.effectId = effectId
        this.effectIndex = effectIndex
        this.comment = comment
        this.adminName = adminName
        this.adminSex = adminSex
    }

    override fun json(inp: Boolean, json: Json): Json {
        effectId = json.m(inp, "effectId", effectId)
        effectIndex = json.m(inp, "effectIndex", effectIndex)
        comment = json.m(inp, "comment", comment)
        adminName = json.m(inp, "adminName", adminName)
        adminSex = json.m(inp, "adminSex", adminSex)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}