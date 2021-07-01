package com.dzen.campfire.api.models.publications.post

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class PagePolling : Page() {

    var pollingId = 0L
    var title = ""
    var options: Array<String> = emptyArray()
    var minLevel = 0L
    var minKarma = 0L

    override fun getType() = API.PAGE_TYPE_POLLING

    override fun json(inp: Boolean, json: Json): Json {
        pollingId = json.m(inp, "pollingId", pollingId)
        title = json.m(inp, "title", title)
        minLevel = json.m(inp, "minLevel", minLevel)
        minKarma = json.m(inp, "minKarma", minKarma)
        options = json.m(inp, "options", options, Array<String>::class)
        return super.json(inp, json)
    }

    class Result : JsonParsable {

        var itemId = 0L
        var count = 0L
        var myVote = false

        override fun json(inp: Boolean, json: Json): Json {
            itemId = json.m(inp, "itemId", itemId)
            count = json.m(inp, "count", count)
            myVote = json.m(inp, "myVote", myVote)
            return json
        }

    }
    override fun fillResourcesList(list: ArrayList<Long>) {

    }

}

