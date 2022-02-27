package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsGetCaptchaSiteKey : Request<RAccountsGetCaptchaSiteKey.Response>() {
    init {
        tokenRequired = false
        tokenDesirable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {}

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {
        var siteKey = ""

        constructor(json: Json) {
            json(false, json)
        }

        constructor(siteKey: String) {
            this.siteKey = siteKey
        }

        override fun json(inp: Boolean, json: Json) {
            siteKey = json.m(inp, "siteKey", siteKey)
        }
    }
}