package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsAdminSetCof(
        var fandomId: Long,
        var cof: Long,
        var comment: String
) : Request<RFandomsAdminSetCof.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        cof = json.m(inp, "cof", cof)
        comment = json.m(inp, "comment", comment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {


        constructor(json: Json) {
        }

        constructor(){
        }

        override fun json(inp: Boolean, json: Json) {
        }

    }

}