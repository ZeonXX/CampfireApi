package com.dzen.campfire.api.requests.publications

import com.dzen.campfire.api.models.publications.PublicationBlocked
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPublicationsBlockGetAll(
        var offset: Long
) : Request<RPublicationsBlockGetAll.Response>() {

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

        var publications: Array<PublicationBlocked> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(publications: Array<PublicationBlocked>) {
            this.publications = publications
        }

        override fun json(inp: Boolean, json: Json) {
            publications = json.m(inp, "units", publications, Array<PublicationBlocked>::class)
        }

    }

}