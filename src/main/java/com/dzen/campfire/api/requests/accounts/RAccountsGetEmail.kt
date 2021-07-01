package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsGetEmail(
) : Request<RAccountsGetEmail.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {

    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var email = ""
        var googleId = ""

        constructor(json: Json) {
            json(false, json)
        }

        constructor(email: String, googleId: String) {
            this.email = email
            this.googleId = googleId
        }

        override fun json(inp: Boolean, json: Json) {
            email = json.m(inp, "email", email)
            googleId = json.m(inp, "googleId", googleId)
        }

    }


}
