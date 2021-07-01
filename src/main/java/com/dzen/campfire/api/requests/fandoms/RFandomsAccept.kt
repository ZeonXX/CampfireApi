package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsAccept(var fandomId: Long, var accepted: Boolean, var comment: String) : Request<RFandomsAccept.Response>() {

    companion object {

        val E_BAD_STATUS = "E_BAD_STATUS"
        val E_SELF = "E_SELF"


    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        accepted = json.m(inp, "accepted", accepted)
        comment = json.m(inp, "comment", comment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {}

    }


}