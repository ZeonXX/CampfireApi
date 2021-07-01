package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsViceroyGet(
        var fandomId: Long,
        var languageId: Long
) : Request<RFandomsViceroyGet.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        languageId = json.m(inp, "languageId", languageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var account:Account? = null
        var date = 0L

        constructor(json: Json) {
            json(false, json)
        }

        constructor(account:Account?, date:Long){
            this.account = account
            this.date = date
        }

        override fun json(inp: Boolean, json: Json) {
            account = json.mNull(inp, "account", account, Account::class)
            date = json.m(inp, "date", date)
        }

    }

}