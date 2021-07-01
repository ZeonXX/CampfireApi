package com.dzen.campfire.api.models.project

import com.dzen.campfire.api.models.account.Account
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class Donate : JsonParsable{

    var account = Account()
    var sum = 0L
    var dateCreate = 0L
    var comment = ""
    var isSum = false
    var isDraft = false

    override fun json(inp: Boolean, json: Json): Json {
        account = json.m(inp, "account", account)
        sum = json.m(inp, "sum", sum)
        dateCreate = json.m(inp, "dateCreate", dateCreate)
        comment = json.m(inp, "comment", comment)
        isSum = json.m(inp, "isSum", isSum)
        isDraft = json.m(inp, "isDraft", isDraft)

        return json
    }

}