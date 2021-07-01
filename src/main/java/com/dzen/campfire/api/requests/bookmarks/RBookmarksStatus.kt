package com.dzen.campfire.api.requests.bookmarks

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RBookmarksStatus(
        var publicationId: Long,
        var foldersIds:Array<Long>
) : Request<RBookmarksStatus.Response>() {

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

        constructor(json: Json) {
            json(false, json)
        }

        constructor(bookmark: Boolean, folderId: Long) {
            this.bookmark = bookmark
            this.folderId = folderId
        }

        override fun json(inp: Boolean, json: Json) {
            bookmark = json.m(inp, "bookmark", bookmark)
            folderId = json.m(inp, "folderId", folderId)
        }

    }

}