package com.dzen.campfire.api.requests.post

import com.dzen.campfire.api.models.publications.post.PublicationPost
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPostPendingGetAll(
        var offset: Long
) : Request<RPostPendingGetAll.Response>() {

    companion object {
        val COUNT = 20
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var publications: Array<PublicationPost> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(publications: Array<PublicationPost>) {
            this.publications = publications
        }

        override fun json(inp: Boolean, json: Json) {
            publications = json.m(inp, "units", publications, Array<PublicationPost>::class)
        }

    }


}