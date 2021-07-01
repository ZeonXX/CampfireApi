package com.dzen.campfire.api.requests.post


import com.dzen.campfire.api.models.publications.Rate
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPostRatesGetAll(
        var publicationId:Long,
        var offset:Long
) : Request<RPostRatesGetAll.Response>() {

    companion object {
        val COUNT = 20
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "unitId", publicationId)
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var rates: Array<Rate> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(rates: Array<Rate>) {
            this.rates = rates
        }

        override fun json(inp: Boolean, json: Json) {
            rates = json.m(inp, "rates", rates, Array<Rate>::class)
        }

    }


}
