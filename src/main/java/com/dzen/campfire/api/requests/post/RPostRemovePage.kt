package com.dzen.campfire.api.requests.post

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPostRemovePage(
        var publicationId: Long,
        var pageIndexes: Array<Int>
) : Request<RPostRemovePage.Response>() {

    companion object {
        val E_BAD_STATUS = "E_BAD_STATUS"
        val E_BAD_PAGE_INDEX = "E_BAD_PAGE_INDEX"
        val E_BAD_TYPE = "E_BAD_TYPE"
        val E_CANT_REMOVE_LAST = "E_CANT_REMOVE_LAST"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        pageIndexes = json.m(inp, "pageIndexes", pageIndexes)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {


        constructor(json: Json) {
            json(false, json)
        }

        constructor() {}

        override fun json(inp: Boolean, json: Json) {

        }

    }


}
