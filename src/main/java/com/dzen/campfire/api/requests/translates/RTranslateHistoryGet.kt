package com.dzen.campfire.api.requests.translates

import com.dzen.campfire.api.models.translate.TranslateHistory
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RTranslateHistoryGet(
        var languageId: Long,
        var key:String,
        var projectKey: String,
        var offsetDate: Long
) : Request<RTranslateHistoryGet.Response>() {

    companion object {
        val COUNT = 50
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        languageId = json.m(inp, "languageId", languageId)
        key = json.m(inp, "key", key)
        projectKey = json.m(inp, "projectKey", projectKey)
        offsetDate = json.m(inp, "offsetDate", offsetDate)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var history: Array<TranslateHistory> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(history: Array<TranslateHistory>) {
            this.history = history
        }

        override fun json(inp: Boolean, json: Json) {
            history = json.m(inp, "history", history)
        }

    }

}