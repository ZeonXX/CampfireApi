package com.dzen.campfire.api.requests.post

import com.dzen.campfire.api.models.publications.post.PagePolling
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPostPagePollingGet(var pollingId: Long) : Request<RPostPagePollingGet.Response>() {

    init {
        cashAvailable = false
        tokenRequired = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        pollingId = json.m(inp, "pollingId", pollingId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var results: Array<PagePolling.Result> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(results: Array<PagePolling.Result>) {
            this.results = results
        }

        override fun json(inp: Boolean, json: Json) {
            results = json.m(inp, "tags", results,  Array<PagePolling.Result>::class)
        }

    }


}