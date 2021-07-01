package com.dzen.campfire.api.models.publications.moderations.posts

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationPostCloseNo : Moderation {

    var postId = 0L

    override fun getType() = API.MODERATION_TYPE_POST_CLSOE_NO

    constructor()

    constructor(comment: String, postId: Long) : super(comment) {
        this.postId = postId
    }

    override fun json(inp: Boolean, json: Json): Json {
        postId = json.m(inp, "postId", postId)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
