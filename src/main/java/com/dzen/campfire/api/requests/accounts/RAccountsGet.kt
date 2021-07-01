package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsGet(
        var accountId:Long,
        var accountName:String
) : Request<RAccountsGet.Response>() {

    init {
        tokenRequired = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
        accountName = json.m(inp, "accountName", accountName)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var account = Account()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(account: Account) {
            this.account = account
        }

        override fun json(inp: Boolean, json: Json) {
            account = json.m(inp, "account", account)
        }

    }


}
