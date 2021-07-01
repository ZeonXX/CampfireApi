package com.dzen.campfire.api.models.publications.moderations.posts

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationPinPostInFandom : Moderation {

    var postId = 0L
    var oldPostId = 0L

    override fun getType() = API.MODERATION_TYPE_TAG_PIN_POST_IN_FANDOM

    constructor()

    constructor(comment: String, postId: Long, oldPostId: Long) : super(comment) {
        this.postId = postId
        this.oldPostId = oldPostId
    }

    override fun json(inp: Boolean, json: Json): Json {
        postId = json.m(inp, "postId", postId)
        oldPostId = json.m(inp, "oldPostId", oldPostId)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
