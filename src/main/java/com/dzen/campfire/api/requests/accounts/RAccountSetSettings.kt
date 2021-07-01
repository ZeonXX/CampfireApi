package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.models.account.AccountSettings
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountSetSettings(
        var settings: AccountSettings
) : Request<RAccountSetSettings.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        settings = json.m(inp, "settings", settings, AccountSettings::class)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {

        }

    }


}
