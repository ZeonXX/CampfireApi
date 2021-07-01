package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsBioSetLink(
        var index: Int,
        var title: String,
        var url: String
) : Request<RAccountsBioSetLink.Response>() {

    companion object {
        val E_BAD_TITLE = "E_BAD_TITLE"
        val E_BAD_URL = "E_BAD_URL"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        index = json.m(inp, "index", index)
        title = json.m(inp, "title", title)
        url = json.m(inp, "url", url)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {

        }

    }

}
