package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RFandomsSubscribeChange(
        var fandomId: Long,
        var languageId: Long,
        var subscriptionType: Long,
        var notifyImportant: Boolean
) : Request<RFandomsSubscribeChange.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        subscriptionType = json.m(inp, "subscriptionType", subscriptionType)
        notifyImportant = json.m(inp, "notifyImportant", notifyImportant)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {}

    }

    companion object {

        val E_BAD_LANGUAGE = "E_BAD_LANGUAGE"
    }


}