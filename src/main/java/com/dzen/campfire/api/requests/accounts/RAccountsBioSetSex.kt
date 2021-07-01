package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsBioSetSex(
        var sex: Long
) : Request<RAccountsBioSetSex.Response>() {

    companion object {
        val E_BAD_SEX = "E_BAD_SEX"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        sex = json.m(inp, "sex", sex)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {

        }

    }

}
