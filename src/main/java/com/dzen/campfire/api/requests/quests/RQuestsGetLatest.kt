package com.dzen.campfire.api.requests.quests

import com.dzen.campfire.api.models.publications.Publication
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RQuestsGetLatest(
    var offsetDate: Long,
    var languageIds: Array<Long>,
) : Request<RQuestsGetLatest.Response>() {
    companion object {
        const val COUNT = 20
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        offsetDate = json.m(inp, "offsetDate", offsetDate)
        languageIds = json.m(inp, "languageIds", languageIds, Array<Long>::class)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {
        var quests = arrayOf<Publication>()

        constructor(quests: Array<Publication>) {
            this.quests = quests
        }
        constructor(json: Json) {
            json(false, json)
        }

        override fun json(inp: Boolean, json: Json) {
            quests = json.m(inp, "quests", quests, Array<Publication>::class)
        }
    }
}
