package com.dzen.campfire.api.requests.bookmarks

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RBookmarksAdd(
        var publicationId: Long,
        var folderId: Long
) : Request<RBookmarksAdd.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        folderId = json.m(inp, "folderId", folderId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {


        constructor(json: Json) {
            json(false, json)
        }

        constructor() {
        }

        override fun json(inp: Boolean, json: Json) {

        }

    }

}