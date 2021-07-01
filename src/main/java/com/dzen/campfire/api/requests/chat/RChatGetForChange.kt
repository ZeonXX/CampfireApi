package com.dzen.campfire.api.requests.chat

import com.dzen.campfire.api.models.chat.ChatMember
import com.dzen.campfire.api.models.chat.ChatParamsConf
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RChatGetForChange(
        var chatId: Long
) : Request<RChatGetForChange.Response>() {

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        chatId = json.m(inp, "chatId", chatId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var chatName = ""
        var chatImageId = 0L
        var myLvl = 0L
        var accounts: Array<ChatMember> = emptyArray()
        var params = ChatParamsConf()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(chatName: String, chatImageId: Long, myLvl: Long, accounts: Array<ChatMember>, params: ChatParamsConf) {
            this.chatName = chatName
            this.chatImageId = chatImageId
            this.myLvl = myLvl
            this.accounts = accounts
            this.params = params
        }

        override fun json(inp: Boolean, json: Json) {
            chatName = json.m(inp, "chatName", chatName)
            chatImageId = json.m(inp, "chatImageId", chatImageId)
            myLvl = json.m(inp, "myLvl", myLvl)
            accounts = json.m(inp, "accounts", accounts)
            params = json.m(inp, "params", params)
        }

    }


}