package com.dzen.campfire.api.models.publications.moderations.fandom

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationBackgroundImageSub : Moderation {

    var imageId = 0L
    var chatId = 0L
    var chatName = ""

    override fun getType() = API.MODERATION_TYPE_BACKGROUND_IMAGE_SUB

    constructor()

    constructor(comment: String, imageId: Long, chatId: Long, chatName: String) : super(comment) {
        this.imageId = imageId
        this.chatId = chatId
        this.chatName = chatName
    }

    override fun json(inp: Boolean, json: Json): Json {
        imageId = json.m(inp, "imageId", imageId)
        chatId = json.m(inp, "chatId", chatId)
        chatName = json.m(inp, "chatName", chatName)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}
