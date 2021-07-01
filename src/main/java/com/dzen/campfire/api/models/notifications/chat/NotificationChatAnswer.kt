package com.dzen.campfire.api.models.notifications.chat

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.chat.ChatTag
import com.dzen.campfire.api.models.notifications.Notification
import com.dzen.campfire.api.models.publications.chat.PublicationChatMessage
import com.sup.dev.java.libs.json.Json

class NotificationChatAnswer : Notification {

    var publicationChatMessage: PublicationChatMessage = PublicationChatMessage()
    var tag = ChatTag()
    var subscribed = false

    override fun isShadow() = true

    override fun isNeedForcePush() = true

    constructor()

    constructor(publicationChatMessage: PublicationChatMessage, tag: ChatTag, subscribed: Boolean) : super(publicationChatMessage.creator.imageId) {
        this.publicationChatMessage = publicationChatMessage
        this.subscribed = subscribed
        this.tag = tag
    }

    override fun json(inp: Boolean, json: Json): Json {
        if (inp) publicationChatMessage.jsonDB = publicationChatMessage.jsonDB(true, Json())
        publicationChatMessage = json.m(inp, "unitChatMessage", publicationChatMessage, PublicationChatMessage::class)
        tag = json.m(inp, "tag", tag, ChatTag::class)
        subscribed = json.m(inp, "subscribed", subscribed)
        return super.json(inp, json)
    }


    override fun getType(): Long {
        return API.NOTIF_CHAT_MESSAGE_ANSWER
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }


}
