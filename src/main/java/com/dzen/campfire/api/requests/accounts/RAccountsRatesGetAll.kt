package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.models.publications.Rate
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsRatesGetAll(
        var accountId:Long,
        var offset:Long
) : Request<RAccountsRatesGetAll.Response>() {

    companion object {
        val COUNT = 20
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
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
