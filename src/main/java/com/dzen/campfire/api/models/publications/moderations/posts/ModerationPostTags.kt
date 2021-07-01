package com.dzen.campfire.api.models.publications.moderations.posts

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationPostTags: Moderation {

    var publicationId = 0L
    var newTags:Array<String> = emptyArray()
    var removedTags:Array<String> = emptyArray()

    override fun getType() = API.MODERATION_TYPE_POST_TAGS

    constructor()

    constructor(publicationId: Long,
                comment: String,
                newTags:Array<String>,
                removedTags:Array<String>) : super(comment) {
        this.publicationId = publicationId
        this.newTags = newTags
        this.removedTags = removedTags
    }

    override fun json(inp: Boolean, json: Json): Json {
        publicationId = json.m(inp, "unitId", publicationId)
        newTags = json.m(inp, "newTags", newTags)
        removedTags = json.m(inp, "removedTags", removedTags)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
