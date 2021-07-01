package com.dzen.campfire.api.models.publications.moderations.chat

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.Moderation
import com.sup.dev.java.libs.json.Json

class ModerationChatRemove : Moderation {

    var chatId = 0L
    var name = ""

    override fun getType() = API.MODERATION_TYPE_CHAT_REMOVE

    constructor()

    constructor(comment: String, chatId: Long, name: String) : super(comment) {
        this.chatId = chatId
        this.name = name
    }

    override fun json(inp: Boolean, json: Json): Json {
        chatId = json.m(inp, "chatId", chatId)
        name = json.m(inp, "name", name)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}