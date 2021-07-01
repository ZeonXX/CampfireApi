package com.dzen.campfire.api.models.publications.moderations.tags

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationTagMoveBetweenCategory : Moderation {

    var tagId = 0L
    var tagName = ""
    var tagOldId = 0L
    var tagOldName = ""
    var tagNewId = 0L
    var tagNewName = ""

    override fun getType() = API.MODERATION_TYPE_TAG_MOVE_BETWEEN_CATEGORY

    constructor()

    constructor(comment: String, tagId: Long, tagName: String, tagOldId: Long, tagOldName: String, tagNewId: Long, tagNewName: String) : super(comment) {
        this.tagId = tagId
        this.tagName = tagName
        this.tagOldId = tagOldId
        this.tagOldName = tagOldName
        this.tagNewId = tagNewId
        this.tagNewName = tagNewName
    }

    override fun json(inp: Boolean, json: Json): Json {
        tagId = json.m(inp, "tagId", tagId)
        tagName = json.m(inp, "tagName", tagName)
        tagName = json.m(inp, "tagName", tagName)
        tagOldId = json.m(inp, "tagOldId", tagOldId)
        tagOldName = json.m(inp, "tagOldName", tagOldName)
        tagNewId = json.m(inp, "tagNewId", tagNewId)
        tagNewName = json.m(inp, "tagNewName", tagNewName)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}
