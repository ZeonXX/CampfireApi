package com.dzen.campfire.api.requests.wiki

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RWikiReorder(
        var itemId: Long,
        var beforeId: Long,
) : Request<RWikiReorder.Response>() {
    companion object {
        const val E_BAD_STATUS = "E_BAD_STATUS"
        const val E_BAD_PAGE_INDEX = "E_BAD_PAGE_INDEX"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        itemId = json.m(inp, "itemId", itemId)
        beforeId = json.m(inp, "beforeId", beforeId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {
        constructor()

        constructor(json: Json) {
            json(false, json)
        }

        override fun json(inp: Boolean, json: Json) {}
    }
}