package com.dzen.campfire.api.requests.wiki

import com.dzen.campfire.api.models.publications.post.Page
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RWikiPageChange(
        var wikiItemId: Long,
        var languageId: Long,
        var page: Page?,
        var pageIndex: Int
) : Request<RWikiPageChange.Response>() {

    companion object {
        val E_BAD_STATUS = "E_BAD_STATUS"
        val E_BAD_PAGE_INDEX = "E_BAD_PAGE_INDEX"
        val E_BAD_TYPE = "E_BAD_TYPE"
        val E_BAD_PAGE = "E_BAD_PAGE"
    }

    init {

        if (page != null) page!!.addInsertData(this)
    }

    override fun updateDataOutput() {
        page!!.restoreInsertData(this, 0)
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        wikiItemId = json.m(inp, "wikiItemId", wikiItemId)
        languageId = json.m(inp, "languageId", languageId)
        page = json.mNull(inp, "page", page, Page::class)
        pageIndex = json.m(inp, "pageIndex", pageIndex)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var page: Page? = null

        constructor(json: Json) {
            json(false, json)
        }

        constructor(page: Page) {
            this.page = page
        }

        override fun json(inp: Boolean, json: Json) {
            page = json.mNull(inp, "page", page, Page::class)
        }

    }

}