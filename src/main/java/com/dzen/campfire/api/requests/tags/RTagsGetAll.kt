package com.dzen.campfire.api.requests.tags

import com.dzen.campfire.api.models.publications.tags.PublicationTag
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RTagsGetAll(var fandomId: Long, var languageId: Long) : Request<RTagsGetAll.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var tags: Array<PublicationTag> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(tags: Array<PublicationTag>) {
            this.tags = tags
        }

        override fun json(inp: Boolean, json: Json) {
            tags = json.m(inp, "tags", tags, Array<PublicationTag>::class)
        }

    }

}