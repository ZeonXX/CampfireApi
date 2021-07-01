package com.dzen.campfire.api.requests.wiki

import com.dzen.campfire.api.models.publications.post.Page
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RWikiPagePut(
        var wikiItemId: Long,
        var pages: Array<Page>,
        var languageId: Long
) : Request<RWikiPagePut.Response>() {

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
        wikiItemId = json.m(inp, "wikiItemId", wikiItemId)
        languageId = json.m(inp, "languageId", languageId)
        pages = json.m(inp, "pages", pages, Array<Page>::class)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var pages: Array<Page> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(pages: Array<Page>) {
            this.pages = pages
        }

        override fun json(inp: Boolean, json: Json) {
            pages = json.m(inp, "pages", pages, Array<Page>::class)
        }

    }



}