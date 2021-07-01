package com.dzen.campfire.api.models.notifications.account

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.account.MAccountEffect
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationEffectAdd : Notification {

    var mAccEffect = MAccountEffect()
    var adminName = ""
    var adminSex = 0L

    constructor()

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_EFFECT_ADD

    constructor(mAccEffect: MAccountEffect, adminName:String, adminSex:Long, adminImageId: Long) : super(adminImageId) {
        this.mAccEffect = mAccEffect
        this.adminName = adminName
        this.adminSex = adminSex
    }

    override fun json(inp: Boolean, json: Json): Json {
        mAccEffect = json.m(inp, "mAccEffect", mAccEffect)
        adminName = json.m(inp, "adminName", adminName)
        adminSex = json.m(inp, "adminSex", adminSex)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}