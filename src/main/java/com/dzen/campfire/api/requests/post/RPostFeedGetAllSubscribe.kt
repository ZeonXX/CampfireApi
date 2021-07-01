package com.dzen.campfire.api.requests.post

import com.dzen.campfire.api.models.publications.Publication
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPostFeedGetAllSubscribe(
        var offsetDate: Long,
        var categoryId:Long
) : Request<RPostFeedGetAllSubscribe.Response>() {

    companion object {
        val COUNT = 10
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        offsetDate = json.m(inp, "offsetDate", offsetDate)
        categoryId = json.m(inp, "categoryId", categoryId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var publications: Array<Publication> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(publications: Array<Publication>) {
            this.publications = publications
        }

        override fun json(inp: Boolean, json: Json) {
            publications = json.m(inp, "units", publications, Array<Publication>::class)
        }

    }



}