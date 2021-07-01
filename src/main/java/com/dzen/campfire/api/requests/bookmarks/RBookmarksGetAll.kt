package com.dzen.campfire.api.requests.bookmarks

import com.dzen.campfire.api.models.publications.Publication
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RBookmarksGetAll(
        var offset: Long,
        var projectKey: String,
        var fandomId: Long,
        var languageId: Long,
        var folderId: Long,
        var foldersIds: Array<Long>
) : Request<RBookmarksGetAll.Response>() {

    companion object {
        val COUNT = 20
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        offset = json.m(inp, "offset", offset)
        projectKey = json.m(inp, "projectKey", projectKey)
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        folderId = json.m(inp, "folderId", folderId)
        foldersIds = json.m(inp, "foldersIds", foldersIds)
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