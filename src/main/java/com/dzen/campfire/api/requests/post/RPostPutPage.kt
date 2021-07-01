package com.dzen.campfire.api.requests.post

import com.dzen.campfire.api.models.publications.post.Page
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPostPutPage(
        var publicationId: Long,
        var pages: Array<Page>,
        var fandomId: Long,
        var languageId: Long,
        var appKey: String,
        var appSubKey: String
) : Request<RPostPutPage.Response>() {

    companion object {
        val E_BAD_STATUS = "E_BAD_STATUS"
        val E_BAD_TYPE = "E_BAD_TYPE"
        val E_BAD_PAGE = "E_BAD_PAGE"
        val E_BAD_PAGES_COUNT = "E_BAD_PAGES_COUNT"
    }

    init {
        for(p in pages) p.addInsertData(this)
    }

    override fun updateDataOutput() {
        var offset = 0
        for(p in pages) offset += p.restoreInsertData(this, offset)
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        appKey = json.m(inp, "appKey", appKey)
        appSubKey = json.m(inp, "appSubKey", appSubKey)
        pages = json.m(inp, "pages", pages, Array<Page>::class)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var publicationId: Long = 0
        var pages: Array<Page> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(publicationId: Long, pages: Array<Page>) {
            this.publicationId = publicationId
            this.pages = pages
        }

        override fun json(inp: Boolean, json: Json) {
            publicationId = json.m(inp, "unitId", publicationId)
            pages = json.m(inp, "pages", pages, Array<Page>::class)
        }

    }



}