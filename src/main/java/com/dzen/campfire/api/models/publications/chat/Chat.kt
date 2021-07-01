package com.dzen.campfire.api.models.publications.chat

import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.models.chat.ChatTag
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable


class Chat : JsonParsable {

    var subscriptionId = 0L
    var chatMessage: PublicationChatMessage = PublicationChatMessage()
    var unreadCount = 0L
    var tag = ChatTag()
    var subscribed = false
    var memberStatus = 0L
    var customImageId = 0L
    var customName = ""
    var readDate =  0L
    var exitDate =  0L
    var backgroundImageId =  0L
    var membersCount =  0L
    //  For Private Type
    var anotherAccount = Account()
    var anotherAccountReadDate = 0L
    //  Fro Conf
    var params = Json()

    override fun json(inp: Boolean, json: Json): Json {
        chatMessage = json.m(inp, "unitChatMessage", chatMessage, PublicationChatMessage::class)
        subscriptionId = json.m(inp, "subscriptionId", subscriptionId)
        unreadCount = json.m(inp, "unreadCount", unreadCount)
        tag = json.m(inp, "tag", tag, ChatTag::class)
        subscribed = json.m(inp, "subscribed", subscribed)
        memberStatus = json.m(inp, "memberStatus", memberStatus)
        customImageId = json.m(inp, "customImageId", customImageId)
        customName = json.m(inp, "customName", customName)
        anotherAccount = json.m(inp, "anotherAccount", anotherAccount)
        anotherAccountReadDate = json.m(inp, "anotherAccountReadDate", anotherAccountReadDate)
        params = json.m(inp, "params", params)
        readDate = json.m(inp, "readDate", readDate)
        exitDate = json.m(inp, "exitDate", exitDate)
        backgroundImageId = json.m(inp, "backgroundImageId", backgroundImageId)
        membersCount = json.m(inp, "membersCount", membersCount)

        return json
    }
}
