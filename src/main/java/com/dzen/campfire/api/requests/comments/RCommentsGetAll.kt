package com.dzen.campfire.api.requests.comments

import com.dzen.campfire.api.models.publications.PublicationComment
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RCommentsGetAll(
        var publicationId : Long,
        var offsetDate: Long,
        var old: Boolean,
        var startFromBottom: Boolean
) : Request<RCommentsGetAll.Response>() {

    companion object {
        val COUNT = 50
    }

    init {
        cashAvailable = false
        tokenRequired = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        offsetDate = json.m(inp, "offsetDate", offsetDate)
        old = json.m(inp, "old", old)
        startFromBottom = json.m(inp, "startFromBottom", startFromBottom)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var publications: Array<PublicationComment> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(publications: Array<PublicationComment>) {
            this.publications = publications
        }

        override fun json(inp: Boolean, json: Json) {
            publications = json.m(inp, "units", publications, Array<PublicationComment>::class)
        }

    }

}