package com.dzen.campfire.api.requests.wiki

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RWikiPageMove(
        var wikiItemId: Long,
        var languageId: Long,
        var pageIndex: Int,
        var targetIndex: Int
) : Request<RWikiPageMove.Response>() {

    companion object {

        val E_BAD_STATUS = "E_BAD_STATUS"
        val E_BAD_PAGE_INDEX = "E_BAD_PAGE_INDEX"
        val E_BAD_TYPE = "E_BAD_TYPE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        wikiItemId = json.m(inp, "wikiItemId", wikiItemId)
        languageId = json.m(inp, "languageId", languageId)
        pageIndex = json.m(inp, "pageIndex", pageIndex)
        targetIndex = json.m(inp, "targetIndex", targetIndex)
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
