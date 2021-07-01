package com.dzen.campfire.api.requests.wiki

import com.dzen.campfire.api.models.wiki.WikiPages
import com.dzen.campfire.api.models.wiki.WikiTitle
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RWikiItemHistoryGet(
        var itemId: Long,
        var languageId:Long,
        var offset:Long
) : Request<RWikiItemHistoryGet.Response>() {

    companion object{
        val COUNT = 20
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        itemId = json.m(inp, "itemId", itemId)
        languageId = json.m(inp, "languageId", languageId)
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var historyList = emptyArray<WikiPages>()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(historyList: Array<WikiPages>) {
            this.historyList = historyList
        }

        override fun json(inp: Boolean, json: Json) {
            historyList = json.m(inp, "historyList", historyList)
        }

    }


}