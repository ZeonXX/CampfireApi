package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RAccountsReport(
        var accountId: Long,
        var comment:String
) : Request<RAccountsReport.Response>() {

    companion object {
        val E_EXIST = "E_EXIST"
    }

    init {
        tokenRequired = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        accountId = json.m(inp, "accountId", accountId)
        comment = json.m(inp, "comment", comment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {


        override fun json(inp: Boolean, json: Json) {

        }
    }



}
