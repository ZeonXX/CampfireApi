package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.models.fandoms.Fandom
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsGetAll(
        var subscribedStatus: Int,
        var offset: Long,
        var languageId: Long,
        var categoryId: Long,
        var name: String,
        var params1: Array<Long>,
        var params2: Array<Long>,
        var params3: Array<Long>,
        var params4: Array<Long>
) : Request<RFandomsGetAll.Response>() {

    companion object {
        val SUBSCRIBE_NONE = 0
        val SUBSCRIBE_YES = 1
        val SUBSCRIBE_NO = 2
        val COUNT = 20
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        subscribedStatus = json.m(inp, "subscribedStatus", subscribedStatus)
        offset = json.m(inp, "offset", offset)
        languageId = json.m(inp, "languageId", languageId)
        categoryId = json.m(inp, "categoryId", categoryId)
        name = json.m(inp, "name", name)
        params1 = json.m(inp, "params1", params1)
        params2 = json.m(inp, "params2", params2)
        params3 = json.m(inp, "params3", params3)
        params4 = json.m(inp, "params4", params4)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var fandoms: Array<Fandom> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(fandoms: Array<Fandom>) {
            this.fandoms = fandoms
        }

        override fun json(inp: Boolean, json: Json) {
            fandoms = json.m(inp, "fandoms", fandoms, Array<Fandom>::class)
        }

    }

}