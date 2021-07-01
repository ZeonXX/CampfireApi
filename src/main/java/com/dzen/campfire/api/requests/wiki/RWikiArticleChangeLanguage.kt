package com.dzen.campfire.api.requests.wiki

import com.dzen.campfire.api.models.wiki.WikiPages
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RWikiArticleChangeLanguage(
        var itemId: Long,
        var fromLanguageId: Long,
        var toLanguageId: Long
) : Request<RWikiArticleChangeLanguage.Response>() {


    override fun jsonSub(inp: Boolean, json: Json) {
        itemId = json.m(inp, "itemId", itemId)
        fromLanguageId = json.m(inp, "fromLanguageId", fromLanguageId)
        toLanguageId = json.m(inp, "toLanguageId", toLanguageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var item =  WikiPages()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(item: WikiPages) {
            this.item = item
        }

        override fun json(inp: Boolean, json: Json) {
            item = json.m(inp, "item", item)
        }

    }

}