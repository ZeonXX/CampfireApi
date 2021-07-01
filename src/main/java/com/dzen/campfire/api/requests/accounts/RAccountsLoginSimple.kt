package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsLoginSimple(
        var tokenNotification: String
) : Request<RAccountsLoginSimple.Response>() {

    init {
        tokenRequired = false
        tokenDesirable = true
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        tokenNotification = json.m(inp, "tokenNotification", tokenNotification)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var version: String = ""
        var account: Account? = null
        var serverTime = 0L

        constructor(json: Json) {
            json(false, json)
        }

        constructor(version:String, account: Account?) {
            this.version = version
            this.account = account
            this.serverTime = System.currentTimeMillis()
        }

        override fun json(inp: Boolean, json: Json) {
            version = json.m(inp, "version", version)
            account = json.mNull(inp, "account", account, Account::class)
            serverTime = json.m(inp, "serverTime", serverTime)
        }

    }


}
