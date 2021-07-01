package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsAdminChangeCategory(
        var fandomId: Long,
        var categoryId: Long,
        var comment: String
) : Request<RFandomsAdminChangeCategory.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        categoryId = json.m(inp, "categoryId", categoryId)
        comment = json.m(inp, "comment", comment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {



        constructor(json:Json){
            json(false, json)
        }

        constructor(){

        }

        override fun json(inp: Boolean, json: Json) {
        }

    }

}