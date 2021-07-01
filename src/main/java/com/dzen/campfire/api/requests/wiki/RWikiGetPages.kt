package com.dzen.campfire.api.requests.wiki

import com.dzen.campfire.api.models.wiki.WikiPages
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RWikiGetPages(
        var itemId: Long,
        var languageId:Long
) : Request<RWikiGetPages.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        itemId = json.m(inp, "itemId", itemId)
        languageId = json.m(inp, "languageId", languageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var wikiPages:WikiPages? = null

        constructor(json: Json) {
            json(false, json)
        }

        constructor(wikiPages: WikiPages?) {
            this.wikiPages = wikiPages
        }

        override fun json(inp: Boolean, json: Json) {
            wikiPages = json.mNull(inp, "wikiPages", wikiPages, WikiPages::class)
        }

    }


}