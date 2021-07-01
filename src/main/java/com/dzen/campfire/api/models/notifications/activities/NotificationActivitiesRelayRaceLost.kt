package com.dzen.campfire.api.models.notifications.activities

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationActivitiesRelayRaceLost : Notification {

    var newAccountId = 0L
    var newAccountName = ""
    var newAccountSex = 0L
    var newAccountImageId = 0L
    var activityId = 0L
    var activityName = ""
    var fandomId = 0L
    var fandomImageId = 0L
    var fandomLanguageId = 0L
    var fandomName = ""

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_ACTIVITIES_RELAY_RACE_LOST

    constructor()

    constructor(
            newAccountId: Long,
            newAccountName: String,
            newAccountSex: Long,
            newAccountImageId: Long,
            activityId: Long,
            activityName: String,
            fandomId: Long,
            fandomImageId: Long,
            fandomLanguageId: Long,
            fandomName: String
    ) : super(fandomImageId) {
        this.newAccountId = newAccountId
        this.newAccountName = newAccountName
        this.newAccountSex = newAccountSex
        this.newAccountImageId = newAccountImageId
        this.activityId = activityId
        this.activityName = activityName
        this.fandomId = fandomId
        this.fandomImageId = fandomImageId
        this.fandomLanguageId = fandomLanguageId
        this.fandomName = fandomName
    }

    override fun json(inp: Boolean, json: Json): Json {
        newAccountId = json.m(inp, "newAccountId", newAccountId)
        newAccountName = json.m(inp, "newAccountName", newAccountName)
        newAccountSex = json.m(inp, "newAccountSex", newAccountSex)
        newAccountImageId = json.m(inp, "newAccountImageId", newAccountImageId)
        activityId = json.m(inp, "activityId", activityId)
        activityName = json.m(inp, "activityName", activityName)
        fandomId = json.m(inp, "fandomId", fandomId)
        fandomImageId = json.m(inp, "fandomImageId", fandomImageId)
        fandomLanguageId = json.m(inp, "fandomLanguageId", fandomLanguageId)
        fandomName = json.m(inp, "fandomName", fandomName)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}