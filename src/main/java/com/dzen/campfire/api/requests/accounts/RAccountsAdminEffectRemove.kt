package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsAdminEffectRemove(
        var effectId: Long,
        var comment: String
) : Request<RAccountsAdminEffectRemove.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        effectId = json.m(inp, "effectId", effectId)
        comment = json.m(inp, "comment", comment)
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
