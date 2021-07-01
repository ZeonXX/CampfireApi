package com.dzen.campfire.api.requests.chat

import com.dzen.campfire.api.models.chat.ChatTag
import com.dzen.campfire.api.models.publications.chat.Chat
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RChatGetInfo(
        var tag : ChatTag
) : Request<RChatGetInfo.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        tag = json.m(inp, "tag", tag)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var myAccountIsBlackList = false
        var anotherAccountIsBlackList = false

        constructor(json: Json) {
            json(false, json)
        }

        constructor(myAccountIsBlackList: Boolean, anotherAccountIsBlackList:Boolean) {
            this.myAccountIsBlackList = myAccountIsBlackList
            this.anotherAccountIsBlackList = anotherAccountIsBlackList
        }

        override fun json(inp: Boolean, json: Json) {
            myAccountIsBlackList = json.m(inp, "myAccountIsBlackList", myAccountIsBlackList)
            anotherAccountIsBlackList = json.m(inp, "anotherAccountIsBlackList", anotherAccountIsBlackList)
        }

    }


}