package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.models.publications.moderations.PublicationModeration
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsModerationGet(var publicationId: Long) : Request<RFandomsModerationGet.Response>() {

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var publication: PublicationModeration? = null

        constructor(json: Json) {
            json(false, json)
        }

        constructor(publication: PublicationModeration) {
            this.publication = publication
        }

        override fun json(inp: Boolean, json: Json) {
            publication = json.mNull(inp, "unit", publication, PublicationModeration::class)
        }

    }


}