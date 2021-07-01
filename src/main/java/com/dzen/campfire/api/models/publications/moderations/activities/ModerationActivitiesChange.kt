package com.dzen.campfire.api.models.publications.moderations.activities

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationActivitiesChange : Moderation {

    var activityId = 0L
    var oldName = ""
    var newName = ""
    var oldDescription = ""
    var newDescription = ""

    override fun getType() = API.MODERATION_TYPE_ACTIVITIES_CHANGE

    constructor()

    constructor(comment: String, activityId: Long, oldName: String, newName: String, oldDescription: String, newDescription: String) : super(comment) {
        this.activityId = activityId
        this.oldName = oldName
        this.newName = newName
        this.oldDescription = oldDescription
        this.newDescription = newDescription
    }

    override fun json(inp: Boolean, json: Json): Json {
        activityId = json.m(inp, "activityId", activityId)
        oldName = json.m(inp, "oldName", oldName)
        newName = json.m(inp, "newName", newName)
        oldDescription = json.m(inp, "oldDescription", oldDescription)
        newDescription = json.m(inp, "newDescription", newDescription)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
