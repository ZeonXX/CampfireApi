package com.dzen.campfire.api.requests.wiki

import com.dzen.campfire.api.models.wiki.WikiTitle
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RWikiItemGet(
        var itemId: Long
) : Request<RWikiItemGet.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        itemId = json.m(inp, "itemId", itemId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var wikiTitle = WikiTitle()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(wikiTitle: WikiTitle) {
            this.wikiTitle = wikiTitle
        }

        override fun json(inp: Boolean, json: Json) {
            wikiTitle = json.m(inp, "wikiTitle", wikiTitle)
        }

    }


}