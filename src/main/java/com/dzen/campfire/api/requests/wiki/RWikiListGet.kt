package com.dzen.campfire.api.requests.wiki

import com.dzen.campfire.api.models.wiki.WikiTitle
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RWikiListGet(
        var fandomId: Long,
        var parentItemId: Long,
        var offset: Long
) : Request<RWikiListGet.Response>() {

    companion object{
        val COUNT = 20
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        parentItemId = json.m(inp, "parentItemId", parentItemId)
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var items: Array<WikiTitle> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(items: Array<WikiTitle>) {
            this.items = items
        }

        override fun json(inp: Boolean, json: Json) {
            items = json.m(inp, "items", items, Array<WikiTitle>::class)
        }

    }


}