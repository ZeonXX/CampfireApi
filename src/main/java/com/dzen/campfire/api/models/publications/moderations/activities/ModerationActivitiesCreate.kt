package com.dzen.campfire.api.models.publications.moderations.activities

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationActivitiesCreate : Moderation {

    var name = ""
    var activityId = 0L

    override fun getType() = API.MODERATION_TYPE_ACTIVITIES_CREATE

    constructor()

    constructor(comment: String, name: String, activityId: Long) : super(comment) {
        this.name = name
        this.activityId = activityId
    }

    override fun json(inp: Boolean, json: Json): Json {
        name = json.m(inp, "name", name)
        activityId = json.m(inp, "activityId", activityId)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
