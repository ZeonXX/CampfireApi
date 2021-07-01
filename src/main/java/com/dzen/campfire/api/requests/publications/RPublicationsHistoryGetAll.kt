package com.dzen.campfire.api.requests.publications

import com.dzen.campfire.api.models.publications.history.HistoryPublication
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPublicationsHistoryGetAll(
        var publicationId: Long,
        var offset: Long
) : Request<RPublicationsHistoryGetAll.Response>() {

    companion object {
        val COUNT = 20
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var history: Array<HistoryPublication> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(history: Array<HistoryPublication>) {
            this.history = history
        }

        override fun json(inp: Boolean, json: Json) {
            history = json.m(inp, "history", history)
        }

    }

}