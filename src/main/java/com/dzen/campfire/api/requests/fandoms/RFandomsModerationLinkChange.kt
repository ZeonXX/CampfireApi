package com.dzen.campfire.api.requests.fandoms


import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsModerationLinkChange(
        var fandomId: Long,
        var languageId: Long,
        var linkId:Long,
        var title: String,
        var url: String,
        var iconIndex: Long,
        var comment: String
) : Request<RFandomsModerationLinkChange.Response>() {

    companion object {
        val E_BAD_SIZE = "E_BAD_SIZE"
    }


    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        title = json.m(inp, "title", title)
        linkId = json.m(inp, "linkId", linkId)
        url = json.m(inp, "url", url)
        iconIndex = json.m(inp, "iconIndex", iconIndex)
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