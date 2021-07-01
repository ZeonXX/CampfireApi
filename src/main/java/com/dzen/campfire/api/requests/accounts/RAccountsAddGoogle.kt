package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsAddGoogle(
        var googleToken:String,
) : Request<RAccountsAddGoogle.Response>() {

    companion object{
        val E_GOOGLE_ID_EXIST = "E_GOOGLE_ID_EXIST"
    }

    protected override fun jsonSub(inp: Boolean, json: Json) {
        googleToken = json.m(inp, "googleToken", googleToken)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var googleId = ""

        constructor(json: Json) {
            json(false, json)
        }

        constructor(googleId:String) {
            this.googleId = googleId
        }

        override fun json(inp: Boolean, json: Json) {
            googleId = json.m(inp, "googleId", googleId)
        }
    }


}
