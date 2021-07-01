package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsAdminRemoveModerator(
        var fandomId: Long,
        var languageId: Long,
        var accountId: Long,
        var comment:String
) : Request<RFandomsAdminRemoveModerator.Response>() {

    companion object {
        val E_NOT_MODERATOR = "E_NOT_MODERATOR"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        accountId = json.m(inp, "accountId", accountId)
        comment = json.m(inp, "comment", comment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {}

    }

}