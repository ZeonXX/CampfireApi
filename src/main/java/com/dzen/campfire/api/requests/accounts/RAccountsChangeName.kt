package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsChangeName(
        var name: String,
        var achievementNotificationEnabled: Boolean
) : Request<RAccountsChangeName.Response>() {

    companion object {
        val E_LOGIN_CHARS = "E_LOGIN_CHARS"
        val E_LOGIN_LENGTH = "E_LOGIN_LENGTH"
        val E_LOGIN_IS_NOT_DEFAULT = "E_LOGIN_IS_NOT_DEFAULT"
        val E_LOGIN_NOT_ENABLED = "E_LOGIN_NOT_ENABLED"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        name = json.m(inp, "name", name)
        achievementNotificationEnabled = json.m(inp, "achievementNotificationEnabled", achievementNotificationEnabled)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {}

    }

}