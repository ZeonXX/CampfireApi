package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsAddEmail(
        var email:String,
        var password:String
) : Request<RAccountsAddEmail.Response>() {

    companion object {
        val E_EMAIL_EXIST = "E_EMAIL_EXIST"
    }

    protected override fun jsonSub(inp: Boolean, json: Json) {
        email = json.m(inp, "email", email)
        password = json.m(inp, "password", password)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {


        constructor(json: Json) {
            json(false, json)
        }

        constructor() {
        }

        override fun json(inp: Boolean, json: Json) {
        }
    }


}
