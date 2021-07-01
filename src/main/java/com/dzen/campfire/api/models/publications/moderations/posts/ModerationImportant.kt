package com.dzen.campfire.api.models.publications.moderations.posts

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationImportant : Moderation {

    var importantPublicationId = 0L
    var isImportant = false

    override fun getType() = API.MODERATION_TYPE_IMPORTANT

    constructor()

    constructor(comment: String, importantUnitId: Long, isImportant: Boolean) : super(comment) {
        this.importantPublicationId = importantUnitId
        this.isImportant = isImportant
    }

    override fun json(inp: Boolean, json: Json): Json {
        importantPublicationId = json.m(inp, "importantUnitId", importantPublicationId)
        isImportant = json.m(inp, "isImportant", isImportant)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
