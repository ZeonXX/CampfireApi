package com.dzen.campfire.api.models.publications.moderations.tags

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationTagChange : Moderation {

    var tagId: Long = 0
    var tagParentId: Long = 0
    var tagName: String = ""
    var tagOldName: String = ""
    var tagImageId: Long = 0
    var tagOldImageId: Long = 0
    var tagParentName: String = ""
    var tagParentImageId: Long = 0


    override fun getType() = API.MODERATION_TYPE_TAG_CHANGE

    constructor()

    constructor(comment: String, tagId: Long, tagParentId: Long, tagName: String, tagOldName: String, tagImageId: Long, tagOldImageId: Long, tagParentName: String, tagParentImageId: Long) {
        this.comment = comment
        this.tagId = tagId
        this.tagParentId = tagParentId
        this.tagName = tagName
        this.tagOldName = tagOldName
        this.tagImageId = tagImageId
        this.tagOldImageId = tagOldImageId
        this.tagParentName = tagParentName
        this.tagParentImageId = tagParentImageId
    }

    override fun json(inp: Boolean, json: Json): Json {
        tagId = json.m(inp, "tagId", tagId)
        tagParentId = json.m(inp, "tagParentId", tagParentId)
        tagName = json.m(inp, "tagName", tagName)
        tagOldName = json.m(inp, "tagOldName", tagOldName)
        tagImageId = json.m(inp, "tagImageId", tagImageId)
        tagOldImageId = json.m(inp, "tagOldImageId", tagOldImageId)
        tagParentName = json.m(inp, "tagParentName", tagParentName)
        tagParentImageId = json.m(inp, "tagParentImageId", tagParentImageId)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {
        list.add(tagImageId)
        list.add(tagOldImageId)
        list.add(tagParentImageId)
    }

}
