package com.dzen.campfire.api.models.chat

import com.dzen.campfire.api.models.account.Account
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class ChatMember : JsonParsable {

    var account = Account()
    var memberLvl = 0L
    var memberStatus = 0L
    var memberOwner = 0L

    constructor() {

    }

    override fun json(inp: Boolean, json: Json): Json {
        account = json.m(inp, "account", account)
        memberLvl = json.m(inp, "memberLvl", memberLvl)
        memberStatus = json.m(inp, "memberStatus", memberStatus)
        memberOwner = json.m(inp, "memberOwner", memberOwner)
        return json
    }

}
