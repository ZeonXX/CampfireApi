package com.dzen.campfire.api.models.publications.moderations.fandom

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json


class ModerationNames: Moderation {

    var newNames:Array<String> = emptyArray()
    var removedNames:Array<String> = emptyArray()

    override fun getType() = API.MODERATION_TYPE_NAMES

    constructor()

    constructor(comment: String,
                newNames:Array<String>,
                removedNames:Array<String>) : super(comment) {
        this.newNames = newNames
        this.removedNames = removedNames
    }

    override fun json(inp: Boolean, json: Json): Json {
        newNames = json.m(inp, "newNames", newNames)
        removedNames = json.m(inp, "removedNames", removedNames)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
