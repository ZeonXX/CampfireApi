package com.dzen.campfire.api.requests.fandoms


import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RFandomsAdminMakeModerator(
        var publicationId: Long,
        var comment: String
) : Request<RFandomsAdminMakeModerator.Response>() {

    companion object {
        val E_ALREADY = "E_ALREADY"
        val E_TOO_MANY = "E_TOO_MANY"
        val E_FANDOM_HAVE_MODERATORS = "E_FANDOM_HAVE_MODERATORS"
        val E_LOW_LVL = "E_LOW_LVL"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        comment = json.m(inp, "comment", comment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        constructor(json: Json) {
            json(false, json)
        }


        constructor() {
        }

        override fun json(inp: Boolean, json: Json) {
        }
    }


}
