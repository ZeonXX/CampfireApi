package com.dzen.campfire.api.models.chat

import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class ChatParamsConf : JsonParsable {

    var allowUserInvite = true
    var allowUserNameAndImage = true
    var isPublic = false

    constructor() {

    }

    constructor(json: Json) {
        json(false, json)
    }

    override fun json(inp: Boolean, json: Json): Json {
        allowUserInvite = json.m(inp, "allowUserInvite", allowUserInvite)
        allowUserNameAndImage = json.m(inp, "allowUserNameAndImage", allowUserNameAndImage)
        isPublic = json.m(inp, "isPublic", isPublic)
        return json
    }

}