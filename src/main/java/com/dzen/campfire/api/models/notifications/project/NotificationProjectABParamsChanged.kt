package com.dzen.campfire.api.models.notifications.project

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationProjectABParamsChanged : Notification {

    var ABParams = Json()

    constructor()

    override fun getType() = API.NOTIF_PROJECT_AB_PARAMS_CHAGED

    override fun isShadow() = true

    override fun isNeedForcePush() = false

    constructor(ABParams: Json) : super(0) {
        this.ABParams = ABParams
    }

    override fun json(inp: Boolean, json: Json): Json {
        ABParams = json.m(inp, "ABParams", ABParams)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}