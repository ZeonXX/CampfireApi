package com.dzen.campfire.api.requests.wiki

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RWikiItemMove(
        var fandomId: Long,
        var itemId: Long,
        var destinationId: Long,
) : Request<RWikiItemMove.Response>() {
    companion object {
        const val E_BAD_STATUS = "E_BAD_STATUS"
        const val E_BAD_PAGE_INDEX = "E_BAD_PAGE_INDEX"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        itemId = json.m(inp, "itemId", itemId)
        destinationId = json.m(inp, "destinationId", destinationId)
    }

    override fun instanceResponse(json: Json): Response = Response(json)

    class Response : Request.Response {
        constructor()
        constructor(json: Json) {
            json(false, json)
        }

        override fun json(inp: Boolean, json: Json) {}
    }
}