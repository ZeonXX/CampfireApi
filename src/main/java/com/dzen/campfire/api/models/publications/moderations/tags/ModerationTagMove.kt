package com.dzen.campfire.api.models.publications.moderations.tags

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationTagMove : Moderation {

    var tagId = 0L
    var tagParentId = 0L
    var tagName = ""
    var tagOtherId = 0L
    var tagOtherName = ""

    override fun getType() = API.MODERATION_TYPE_TAG_MOVE

    constructor()

    constructor(comment: String, tagId: Long, tagParentId: Long, tagName: String, tagOtherId: Long, tagOtherName: String) : super(comment) {
        this.tagId = tagId
        this.tagParentId = tagParentId
        this.tagName = tagName
        this.tagOtherId = tagOtherId
        this.tagOtherName = tagOtherName
    }

    override fun json(inp: Boolean, json: Json): Json {
        tagId = json.m(inp, "tagId", tagId)
        tagParentId = json.m(inp, "tagParentId", tagParentId)
        tagName = json.m(inp, "tagName", tagName)
        tagName = json.m(inp, "tagName", tagName)
        tagOtherId = json.m(inp, "tagOtherId", tagOtherId)
        tagOtherName = json.m(inp, "tagOtherName", tagOtherName)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}
