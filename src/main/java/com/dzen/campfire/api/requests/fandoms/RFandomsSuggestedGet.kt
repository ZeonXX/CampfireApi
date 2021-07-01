package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.models.fandoms.Fandom
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RFandomsSuggestedGet(var fandomId: Long) : Request<RFandomsSuggestedGet.Response>() {

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var fandom: Fandom? = null
        var creator = Account()
        var params1: Array<Long> = emptyArray()
        var params2: Array<Long> = emptyArray()
        var params3: Array<Long> = emptyArray()
        var params4: Array<Long> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(fandom: Fandom,
                    creator: Account,
                    params1: Array<Long>,
                    params2: Array<Long>,
                    params3: Array<Long>,
                    params4: Array<Long>
        ) {
            this.fandom = fandom
            this.creator = creator
            this.params1 = params1
            this.params2 = params2
            this.params3 = params3
            this.params4 = params4
        }

        override fun json(inp: Boolean, json: Json) {
            fandom = json.mNull(inp, "fandom", fandom, Fandom::class)
            creator = json.m(inp, "creator", creator)
            params1 = json.m(inp, "params1", params1)
            params2 = json.m(inp, "params2", params2)
            params3 = json.m(inp, "params3", params3)
            params4 = json.m(inp, "params4", params4)
        }

    }


}