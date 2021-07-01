package com.dzen.campfire.api.requests.post

import com.dzen.campfire.api.models.publications.post.PublicationPost
import com.dzen.campfire.api.models.publications.tags.PublicationTag
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPostGet(var publicationId: Long) : Request<RPostGet.Response>() {

    companion object{

        val GONE_BLOCKED = "GONE_BLOCKED"
        val GONE_DRAFT = "GONE_DRAFT"
        val GONE_REMOVE = "REMOVE"

    }

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

        var publication: PublicationPost = PublicationPost()
        var tags: Array<PublicationTag> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(publication: PublicationPost, tags: Array<PublicationTag>) {
            this.publication = publication
            this.tags = tags
        }

        override fun json(inp: Boolean, json: Json) {
            publication = json.m(inp, "unit", publication, PublicationPost::class)
            tags = json.m(inp, "tags", tags, Array<PublicationTag>::class)
        }

    }


}