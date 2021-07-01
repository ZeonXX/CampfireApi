package com.dzen.campfire.api.models.notifications.activities

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationActivitiesRelayRaceTurn : Notification {

    var fromAccountId = 0L
    var fromAccountName = ""
    var fromAccountSex = 0L
    var fromAccountImageId = 0L
    var activityId = 0L
    var activityName = ""
    var fandomId = 0L
    var fandomImageId = 0L
    var fandomLanguageId = 0L
    var fandomName = ""

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_ACTIVITIES_RELAY_RACE_TURN

    constructor()

    constructor(
            fromAccountId: Long,
            fromAccountName: String,
            fromAccountSex: Long,
            fromAccountImageId: Long,
            activityId: Long,
            activityName: String,
            fandomId: Long,
            fandomImageId: Long,
            fandomLanguageId: Long,
            fandomName: String
    ) : super(fandomImageId) {
        this.fromAccountId = fromAccountId
        this.fromAccountName = fromAccountName
        this.fromAccountSex = fromAccountSex
        this.fromAccountImageId = fromAccountImageId
        this.activityId = activityId
        this.activityName = activityName
        this.fandomId = fandomId
        this.fandomImageId = fandomImageId
        this.fandomLanguageId = fandomLanguageId
        this.fandomName = fandomName
    }

    override fun json(inp: Boolean, json: Json): Json {
        fromAccountId = json.m(inp, "fromAccountId", fromAccountId)
        fromAccountName = json.m(inp, "fromAccountName", fromAccountName)
        fromAccountSex = json.m(inp, "fromAccountSex", fromAccountSex)
        fromAccountImageId = json.m(inp, "fromAccountImageId", fromAccountImageId)
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
