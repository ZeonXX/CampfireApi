package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.models.fandoms.Fandom
import com.dzen.campfire.api.models.fandoms.FandomLink
import com.dzen.campfire.api.models.publications.post.PublicationPost
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsGetSubscribtion(
        var fandomId: Long,
        var languageId: Long
) : Request<RFandomsGetSubscribtion.Response>() {

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var subscriptionType = 0L
        var notifyImportant = false

        constructor(json: Json) {
            json(false, json)
        }

        constructor(subscriptionType: Long,
                    notifyImportant: Boolean
        ) {
            this.subscriptionType = subscriptionType
            this.notifyImportant = notifyImportant
        }

        override fun json(inp: Boolean, json: Json) {
            subscriptionType = json.m(inp, "subscriptionType", subscriptionType)
            notifyImportant = json.m(inp, "notifyImportant", notifyImportant)
        }

    }

}