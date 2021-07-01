package com.dzen.campfire.api.models.fandoms

import com.dzen.campfire.api.models.account.Account
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class Rubric : JsonParsable {

    var id = 0L
    var name = ""
    var karmaCof = 0L
    var dateCreate = 0L
    var creatorId = 0L
    var fandom = Fandom()
    var owner = Account()
    var status = 0L
    var statusChangeDate = 0L
    var isWaitForPost = false

    override fun json(inp: Boolean, json: Json): Json {
        id = json.m(inp, "id", id)
        name = json.m(inp, "name", name)
        owner = json.m(inp, "owner", owner)
        karmaCof = json.m(inp, "karmaCof", karmaCof)
        dateCreate = json.m(inp, "dateCreate", dateCreate)
        creatorId = json.m(inp, "creatorId", creatorId)
        fandom = json.m(inp, "fandom", fandom)
        status = json.m(inp, "status", status)
        statusChangeDate = json.m(inp, "statusChangeDate", statusChangeDate)
        isWaitForPost = json.m(inp, "isWaitForPost", isWaitForPost)

        return json
    }


}