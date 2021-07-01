package com.dzen.campfire.api.models.publications.moderations.fandom

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationDescription : Moderation {

    var description = ""

    override fun getType() = API.MODERATION_TYPE_DESCRIPTION

    constructor()

    constructor(comment: String, description: String) : super(comment) {
        this.description = description
    }

    override fun json(inp: Boolean, json: Json): Json {
        description = json.m(inp, "description", description)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
