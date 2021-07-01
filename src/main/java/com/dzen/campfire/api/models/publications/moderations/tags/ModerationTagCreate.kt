package com.dzen.campfire.api.models.publications.moderations.tags

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationTagCreate : Moderation {

    var tagId = 0L
    var tagParentId = 0L
    var tagName = ""
    var tagImageId = 0L
    var tagParentName = ""
    var tagParentImageId = 0L

    override fun getType() = API.MODERATION_TYPE_TAG_CREATE

    constructor()

    constructor(comment: String, tagId: Long, tagParentId: Long, tagName: String, tagImageId: Long, tagParentName: String, tagParentImageId: Long) : super(comment) {
        this.tagId = tagId
        this.tagParentId = tagParentId
        this.tagName = tagName
        this.tagImageId = tagImageId
        this.tagParentName = tagParentName
        this.tagParentImageId = tagParentImageId
    }

    override fun json(inp: Boolean, json: Json): Json {
        tagId = json.m(inp, "tagId", tagId)
        tagParentId = json.m(inp, "tagParentId", tagParentId)
        tagName = json.m(inp, "tagName", tagName)
        tagImageId = json.m(inp, "tagImageId", tagImageId)
        tagParentName = json.m(inp, "tagParentName", tagParentName)
        tagParentImageId = json.m(inp, "tagParentImageId", tagParentImageId)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {
        list.add(tagImageId)
        list.add(tagParentImageId)
    }

}
