package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.models.fandoms.KarmaInFandom
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsKarmaInFandomsGetAll(
        var accountId:Long,
        var offset:Long
) : Request<RAccountsKarmaInFandomsGetAll.Response>() {

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

        var karma: Array<KarmaInFandom> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(karma: Array<KarmaInFandom>) {
            this.karma = karma
        }

        override fun json(inp: Boolean, json: Json) {
            karma = json.m(inp, "karma", karma, Array<KarmaInFandom>::class)
        }

    }


}
