package com.dzen.campfire.api.requests.post


import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPostMenuInfoGet(
        var publicationId: Long,
        var foldersIds:Array<Long>
) : Request<RPostMenuInfoGet.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "publicationId", publicationId)
        foldersIds = json.m(inp, "foldersIds", foldersIds)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var bookmark = false
        var folderId = 0L
        var follow = false


        constructor(json: Json) {
            json(false, json)
        }

        constructor(bookmark: Boolean, folderId: Long, follow:Boolean) {
            this.bookmark = bookmark
            this.folderId = folderId
            this.follow = follow
        }

        override fun json(inp: Boolean, json: Json) {
            bookmark = json.m(inp, "bookmark", bookmark)
            folderId = json.m(inp, "folderId", folderId)
            follow = json.m(inp, "follow", follow)
        }

    }

}