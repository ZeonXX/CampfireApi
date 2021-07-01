package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsAdminChangeParams(
        var fandomId: Long,
        var categoryId: Long,
        var paramsPosition: Int,
        var params:Array<Long>,
        var comment: String
) : Request<RFandomsAdminChangeParams.Response>() {

    companion object {
        val E_BAD_TYPE = "E_BAD_TYPE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        categoryId = json.m(inp, "categoryId", categoryId)
        paramsPosition = json.m(inp, "paramsPosition", paramsPosition)
        comment = json.m(inp, "comment", comment)
        params = json.m(inp, "platforms", params)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {}

    }


}
