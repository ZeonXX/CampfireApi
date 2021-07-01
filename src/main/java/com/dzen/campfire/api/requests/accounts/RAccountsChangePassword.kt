package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsChangePassword(
        var email:String,
        var oldPassword:String,
        var newPassword:String
) : Request<RAccountsChangePassword.Response>() {

    protected override fun jsonSub(inp: Boolean, json: Json) {
        email = json.m(inp, "email", email)
        oldPassword = json.m(inp, "oldPassword", oldPassword)
        newPassword = json.m(inp, "newPassword", newPassword)
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
