package com.dzen.campfire.api.requests.tags

import com.dzen.campfire.api.models.publications.tags.PublicationTag
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RTagsGet(var tagId: Long) : Request<RTagsGet.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        tagId = json.m(inp, "tagId", tagId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var tag = PublicationTag()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(tag: PublicationTag) {
            this.tag = tag
        }

        override fun json(inp: Boolean, json: Json) {
            tag = json.m(inp, "tag", tag, PublicationTag::class)
        }

    }

}