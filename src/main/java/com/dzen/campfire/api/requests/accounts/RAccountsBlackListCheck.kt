package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsBlackListCheck(
        var accountId: Long
) : Request<RAccountsBlackListCheck.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var isInBlackList = false

        constructor(json: Json){
            json(false, json)
        }

        constructor(isInBlackList:Boolean){
            this.isInBlackList = isInBlackList
        }

        override fun json(inp: Boolean, json: Json) {
            isInBlackList = json.m(inp, "isInBlackList", isInBlackList)
        }

    }


}
