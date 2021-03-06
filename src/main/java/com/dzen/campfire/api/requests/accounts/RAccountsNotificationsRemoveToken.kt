package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RAccountsNotificationsRemoveToken(var tokenNotification: String) : Request<RAccountsNotificationsRemoveToken.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        tokenNotification = json.m(inp, "tokenNotification", tokenNotification)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        constructor(json: Json) {
            json(false, json)
        }

        constructor() {

        }

        override fun json(inp: Boolean, json: Json) {

        }

    }


}