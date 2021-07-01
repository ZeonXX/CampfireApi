package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.models.fandoms.Fandom
import com.dzen.campfire.api.models.fandoms.FandomLink
import com.dzen.campfire.api.models.publications.post.PublicationPost
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsGet(
        var fandomId: Long,
        var languageId: Long,
        var accountLanguageId: Long
) : Request<RFandomsGet.Response>() {

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
        accountLanguageId = json.m(inp, "accountLanguageId", accountLanguageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var fandom: Fandom = Fandom()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(fandom: Fandom
        ) {
            this.fandom = fandom
        }

        override fun json(inp: Boolean, json: Json) {
            fandom = json.m(inp, "fandom", fandom, Fandom::class)
        }

    }

}