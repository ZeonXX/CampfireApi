package com.dzen.campfire.api.requests.wiki

import com.dzen.campfire.api.models.wiki.WikiTitle
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RWikiGet(
        var itemId: Long
) : Request<RWikiGet.Response>() {


    override fun jsonSub(inp: Boolean, json: Json) {
        itemId = json.m(inp, "itemId", itemId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var item =  WikiTitle()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(item: WikiTitle) {
            this.item = item
        }

        override fun json(inp: Boolean, json: Json) {
            item = json.m(inp, "item", item)
        }

    }

}