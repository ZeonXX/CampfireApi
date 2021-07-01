package com.dzen.campfire.api.requests.accounts


import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsRatingGet() : Request<RAccountsRatingGet.Response>() {

    companion object {
        val COUNT = 50
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {

    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }


    class Response : Request.Response {

        var forceAccounts: Array<Account> = emptyArray()
        var karmaAccounts: Array<Account> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(forceAccounts: Array<Account>, karmaAccounts: Array<Account>) {
            this.forceAccounts = forceAccounts
            this.karmaAccounts = karmaAccounts
        }

        override fun json(inp: Boolean, json: Json) {
            forceAccounts = json.m(inp, "forceAccounts", forceAccounts, Array<Account>::class)
            karmaAccounts = json.m(inp, "karmaAccounts", karmaAccounts, Array<Account>::class)
        }
    }

}