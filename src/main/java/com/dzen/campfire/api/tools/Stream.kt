package com.dzen.campfire.api.tools

import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class StreamClientHandshake : JsonParsable {
    var loginToken: String? = null
    var subscribe = arrayOf<Long>()

    override fun json(inp: Boolean, json: Json): Json {
        loginToken = json.mNull(inp, "loginToken", loginToken, String::class)
        subscribe = json.m(inp, "subscribe", subscribe, Array<Long>::class)
        return json
    }
}

class StreamServerHandshake : JsonParsable {
    companion object {
        const val SUCCESS = 0L
        const val E_UNAUTHORIZED = 1L
        const val E_SUB_AMOUNT = 2L
        const val E_ALREADY = 3L
    }

    var error = 0L

    override fun json(inp: Boolean, json: Json): Json {
        error = json.m(inp, "error", error)
        return json
    }
}


