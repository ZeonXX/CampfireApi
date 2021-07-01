package com.dzen.campfire.api.models.publications.moderations.fandom

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationGalleryRemove : Moderation {

    override fun getType() = API.MODERATION_TYPE_GELLERY_REMOVE

    constructor()

    constructor(comment: String) : super(comment) {
    }

    override fun json(inp: Boolean, json: Json): Json {
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
