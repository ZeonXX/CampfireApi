package com.dzen.campfire.api.requests.wiki

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RWikiItemHistoryRestore(
        var pagesId: Long
) : Request<RWikiItemHistoryRestore.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        pagesId = json.m(inp, "pagesId", pagesId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var newPagesId = 0L


        constructor(json: Json) {
            json(false, json)
        }

        constructor(newPagesId:Long) {
            this.newPagesId=  newPagesId
        }

        override fun json(inp: Boolean, json: Json) {
            newPagesId = json.m(inp, "newPagesId", newPagesId)
        }

    }


}