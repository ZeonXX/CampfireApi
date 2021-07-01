package com.dzen.campfire.api.models.notifications.activities

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationActivitiesNewPost : Notification {

    var activityId = 0L
    var activityName = ""
    var postId = 0L
    var fandomId = 0L
    var fandomImageId = 0L
    var fandomLanguageId = 0L
    var fandomName = ""

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_ACTIVITIES_NEW_POST

    constructor()

    constructor(
            activityId: Long,
            activityName: String,
            postId: Long,
            fandomId: Long,
            fandomImageId: Long,
            fandomLanguageId: Long,
            fandomName: String
    ) : super(fandomImageId) {
        this.activityId = activityId
        this.activityName = activityName
        this.postId = postId
        this.fandomId = fandomId
        this.fandomImageId = fandomImageId
        this.fandomLanguageId = fandomLanguageId
        this.fandomName = fandomName
    }

    override fun json(inp: Boolean, json: Json): Json {
        activityId = json.m(inp, "activityId", activityId)
        activityName = json.m(inp, "activityName", activityName)
        postId = json.m(inp, "postId", postId)
        fandomId = json.m(inp, "fandomId", fandomId)
        fandomImageId = json.m(inp, "fandomImageId", fandomImageId)
        fandomLanguageId = json.m(inp, "fandomLanguageId", fandomLanguageId)
        fandomName = json.m(inp, "fandomName", fandomName)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
