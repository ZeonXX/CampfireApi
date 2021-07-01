package com.dzen.campfire.api.requests.publications

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RPublicationsKarmaAdd(
        var publicationId: Long,
        var up: Boolean,
        var userLanguage: Long,
        var anon: Boolean
) : Request<RPublicationsKarmaAdd.Response>() {

    companion object {
        val E_ALREADY_EXIST = "E_ALREADY_EXIST"
        val E_SELF_PUBLICATION = "E_SELF_PUBLICATION"
        val E_BAD_TYPE = "E_BAD_TYPE"
        val E_CANT_DOWN = "E_CANT_DOWN"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        up = json.m(inp, "up", up)
        userLanguage = json.m(inp, "userLanguage", userLanguage)
        anon = json.m(inp, "anon", anon)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var myKarmaCount = 0L

        constructor(json: Json) {
            json(false, json)
        }


        constructor(myKarmaCount: Long) {
            this.myKarmaCount = myKarmaCount
        }

        override fun json(inp: Boolean, json: Json) {
            myKarmaCount = json.m(inp, "myKarmaCount", myKarmaCount)
        }

    }



}