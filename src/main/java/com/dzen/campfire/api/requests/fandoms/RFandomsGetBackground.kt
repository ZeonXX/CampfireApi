package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.models.fandoms.Fandom
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsGetBackground(
        var fandomId: Long,
        var languageId: Long
) : Request<RFandomsGetBackground.Response>() {

    companion object {
        val COUNT = 20
    }

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

        var imageTitleId = 0L
        var imageTitleGifId = 0L

        constructor(json: Json) {
            json(false, json)
        }

        constructor(imageTitleId: Long, imageTitleGifId:Long) {
            this.imageTitleId = imageTitleId
            this.imageTitleGifId = imageTitleGifId
        }

        override fun json(inp: Boolean, json: Json) {
            imageTitleId = json.m(inp, "imageTitleId", imageTitleId)
            imageTitleGifId = json.m(inp, "imageTitleGifId", imageTitleGifId)
        }

    }

}