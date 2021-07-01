package com.dzen.campfire.api.models.account

import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class MAccountEffect : JsonParsable {

    var id = 0L
    var accountId = 0L
    var dateCreate = 0L
    var dateEnd = 0L
    var comment = ""
    var effectIndex = 0L
    var tag = 0L
    var commentTag = 0L
    var fromAccountName = ""

    override fun json(inp: Boolean, json: Json): Json {
        id = json.m(inp, "id", id)
        accountId = json.m(inp, "accountId", accountId)
        dateCreate = json.m(inp, "dateCreate", dateCreate)
        dateEnd = json.m(inp, "dateEnd", dateEnd)
        comment = json.m(inp, "comment", comment)
        effectIndex = json.m(inp, "effectIndex", effectIndex)
        tag = json.m(inp, "tag", tag)
        commentTag = json.m(inp, "commentTag", commentTag)
        fromAccountName = json.m(inp, "fromAccountName", fromAccountName)
        return json
    }

}