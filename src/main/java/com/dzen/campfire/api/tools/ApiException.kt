package com.dzen.campfire.api.tools

import com.sup.dev.java.libs.debug.Debug
import com.sup.dev.java.libs.json.Json

class ApiException constructor(
        var code: String,
        var messageError: String,
        var params: Array<String>
) : Exception(code + " " + messageError + " " + Debug.asString(params, true)) {

    var salient = false

    companion object {

        fun instance(code: String, messageError: String, vararg args: Any?): ApiException {
            return ApiException(code, messageError, Array(args.size) { "${args[it]}" })
        }

    }

    constructor(code: String, messageError: String) : this(code, messageError, emptyArray())

    constructor(code: String) : this(code, "", emptyArray())

    constructor() : this("", "", emptyArray())

    constructor(json: Json) : this(json.getString("code", "null"), json.getString("messageError", "null"), json.m(false, "params", emptyArray<String>())) {
        json(false, json)
    }

    fun json(inp: Boolean, json: Json) {
        this.code = json.m(inp, "code", code)
        this.messageError = json.m(inp, "messageError", messageError)
        this.params = json.m(inp, "params", params)
    }

    fun salient(): ApiException {
        this.salient = true
        return this
    }

}