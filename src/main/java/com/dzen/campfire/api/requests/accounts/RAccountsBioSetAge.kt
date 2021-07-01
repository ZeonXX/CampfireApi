package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsBioSetAge(
        var age: Long
) : Request<RAccountsBioSetAge.Response>() {

    companion object {
        val E_BAD_AGE = "E_BAD_AGE"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        age = json.m(inp, "age", age)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {

        }

    }

}
