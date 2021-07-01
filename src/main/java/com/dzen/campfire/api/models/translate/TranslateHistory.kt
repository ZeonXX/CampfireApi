package com.dzen.campfire.api.models.translate

import com.dzen.campfire.api.models.account.Account
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class TranslateHistory: JsonParsable{

    companion object{

        val TYPE_TEXT = 1L
        val TYPE_HINT = 2L

    }

    var id = 0L
    var languageId = 0L
    var fromLanguageId = 0L
    var key = ""
    var oldText = ""
    var newText = ""
    var projectKey = ""
    var comment = ""
    var type = 0L
    var dateCreated = 0L
    var confirm_account_1 = 0L
    var confirm_account_2 = 0L
    var confirm_account_3 = 0L
    var creator:Account=Account()

    override fun json(inp: Boolean, json: Json): Json {
        id = json.m(inp, "id", id)
        languageId = json.m(inp, "languageId", languageId)
        fromLanguageId = json.m(inp, "fromLanguageId", fromLanguageId)
        key = json.m(inp, "key", key)
        oldText = json.m(inp, "oldText", oldText)
        newText = json.m(inp, "newText", newText)
        projectKey = json.m(inp, "projectKey", projectKey)
        comment = json.m(inp, "comment", comment)
        type = json.m(inp, "type", type)
        dateCreated = json.m(inp, "dateCreated", dateCreated)
        creator = json.m(inp, "creator", creator)
        confirm_account_1 = json.m(inp, "confirm_account_1", confirm_account_1)
        confirm_account_2 = json.m(inp, "confirm_account_2", confirm_account_2)
        confirm_account_3 = json.m(inp, "confirm_account_3", confirm_account_3)
        return json
    }


}