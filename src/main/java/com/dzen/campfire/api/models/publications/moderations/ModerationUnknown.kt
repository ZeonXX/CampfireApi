package com.dzen.campfire.api.models.publications.moderations

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class ModerationUnknown : Moderation {

    override fun getType() = API.MODERATION_TYPE_UNKNOWN

    constructor()


    override fun json(inp: Boolean, json: Json): Json {
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}