package com.dzen.campfire.api.requests.translates

import com.dzen.campfire.api.models.translate.TranslateHistory
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RTranslateModerationGet(
        var offset : Long
) : Request<RTranslateModerationGet.Response>() {

    companion object{
        val COUNT = 20
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var histories:Array<TranslateHistory> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(histories: Array<TranslateHistory>) {
            this.histories = histories
        }

        override fun json(inp: Boolean, json: Json) {
            histories = json.m(inp, "histories", histories)
        }

    }

}