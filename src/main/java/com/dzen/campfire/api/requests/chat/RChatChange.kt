package com.dzen.campfire.api.requests.chat

import com.dzen.campfire.api.models.chat.ChatParamsConf
import com.dzen.campfire.api.models.chat.ChatTag
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RChatChange(
        var chatId : Long,
        var name : String?,
        var image:ByteArray?,
        var newAccounts:Array<Long>,
        var removeAccounts:Array<Long>,
        var changeAccounts:Array<Long>,
        var changeAccountsLevels:Array<Long>,
        var chatParams: ChatParamsConf
) : Request<RChatChange.Response>() {

    init {
        addDataOutput(image)
    }

    override fun updateDataOutput() {
        image = dataOutput[0]
    }
    override fun jsonSub(inp: Boolean, json: Json) {
        chatId = json.m(inp, "chatId", chatId)
        name = json.mNull(inp, "name", name, String::class)
        newAccounts = json.m(inp, "newAccounts", newAccounts)
        removeAccounts = json.m(inp, "removeAccounts", removeAccounts)
        changeAccounts = json.m(inp, "changeAccounts", changeAccounts)
        changeAccountsLevels = json.m(inp, "changeAccountsLevels", changeAccountsLevels)
        chatParams = json.m(inp, "chatParams", chatParams)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var tag = ChatTag()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(tag: ChatTag) {
            this.tag = tag
        }

        override fun json(inp: Boolean, json: Json) {
            tag = json.m(inp, "tag", tag)
        }

    }

}