package com.dzen.campfire.api.models.notifications.rubrics

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.Notification
import com.sup.dev.java.libs.json.Json

class NotificationRubricsKarmaCofChanged: Notification {


    var rubricId = 0L
    var rubricName = ""
    var newCof = 0L
    var cofChange = 0L
    var fandomId = 0L
    var languageId = 0L

    override fun isShadow() = false

    override fun isNeedForcePush() = true

    override fun getType() = API.NOTIF_RUBRICS_KARMA_COF_CHANGED

    constructor() {

    }

    constructor(
            rubricId:Long,
            rubricName:String,
            newCof:Long,
            cofChange: Long,
            fandomImageId:Long,
            fandomId:Long,
            languageId:Long
    ) : super(fandomImageId) {
        this.rubricId = rubricId
        this.rubricName = rubricName
        this.newCof = newCof
        this.cofChange = cofChange
        this.fandomId = fandomId
        this.languageId = languageId
    }

    override fun json(inp: Boolean, json: Json): Json {
        rubricId = json.m(inp, "rubricId", rubricId)
        rubricName = json.m(inp, "rubricName", rubricName)
        newCof = json.m(inp, "newCof", newCof)
        cofChange = json.m(inp, "cofChange", cofChange)
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
