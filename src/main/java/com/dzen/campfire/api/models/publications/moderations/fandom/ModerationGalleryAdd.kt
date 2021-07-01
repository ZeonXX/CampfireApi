package com.dzen.campfire.api.models.publications.moderations.fandom

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationGalleryAdd : Moderation {

    var imageId = 0L

    override fun getType() = API.MODERATION_TYPE_GALLERY_ADD

    constructor()

    constructor(comment: String, imageId: Long) : super(comment) {
        this.imageId = imageId
    }

    override fun json(inp: Boolean, json: Json): Json {
        imageId = json.m(inp, "imageId", imageId)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
