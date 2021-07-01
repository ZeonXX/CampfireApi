package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsGetAll : Request<RAccountsGetAll.Response>() {

    companion object {
        val COUNT = 20
    }

    var username: String? = null
    var offset = 0L
    var isSubscriptionsOnly = false

    init {
        cashAvailable = false
    }

    fun setUsername(username: String): RAccountsGetAll {
        this.username = username
        return this
    }

    fun setOffset(offset: Long): RAccountsGetAll {
        this.offset = offset
        return this
    }

    fun setSubscriptionsOnly(isSubscriptionsOnly: Boolean): RAccountsGetAll {
        this.isSubscriptionsOnly = isSubscriptionsOnly
        return this
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        username = json.mNull(inp, "username", username, String::class)
        offset = json.m(inp, "offset", offset)
        isSubscriptionsOnly = json.m(inp, "isSubscriptionsOnly", isSubscriptionsOnly)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var accounts = emptyArray<Account>()
        var isSubscriptions = false

        constructor(json: Json) {
            json(false, json)
        }

        constructor(accounts: Array<Account>, isSubscriptions:Boolean) {
            this.accounts = accounts
            this.isSubscriptions= isSubscriptions
        }

        override fun json(inp: Boolean, json: Json) {
            accounts = json.m(inp, "accounts", accounts)
            isSubscriptions = json.m(inp, "isSubscriptions", isSubscriptions)
        }

    }


}
