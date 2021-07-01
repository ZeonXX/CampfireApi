package com.dzen.campfire.api.requests.post

import com.dzen.campfire.api.models.publications.Publication
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPostGetAllByRubric(
        var rubricId: Long,
        var offset: Long
) : Request<RPostGetAllByRubric.Response>() {

    companion object {
        val COUNT = 20
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        rubricId = json.m(inp, "rubricId", rubricId)
        offset = json.m(inp, "offset", offset)
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