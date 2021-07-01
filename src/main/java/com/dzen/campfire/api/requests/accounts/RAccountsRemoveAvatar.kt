package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RAccountsRemoveAvatar(var accountId: Long, var comment:String) : Request<RAccountsRemoveAvatar.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
        comment = json.m(inp, "comment", comment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {


        constructor(json:Json){
            json(false, json)
        }

        constructor(){

        }

        override fun json(inp: Boolean, json: Json) {

        }


    }


}
