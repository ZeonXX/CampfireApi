package com.dzen.campfire.api.models.account

import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class AccountPunishment : JsonParsable {

    companion object {

        fun createSupportString(comment:String, fromAccountId:Long, fromAccountImageId:Long, fromAccountName:String,  fromAccountSex:Long, banDate:Long):String{
            return Json()
                    .put("comment", comment)
                    .put("fromAccountId", fromAccountId)
                    .put("fromAccountImageId", fromAccountImageId)
                    .put("fromAccountName", fromAccountName)
                    .put("fromAccountSex", fromAccountSex)
                    .put("banDate", banDate)
                    .toString()
        }

    }

    var id = 0L
    var ownerId = 0L
    var comment = ""
    var fandomId = 0L
    var fandomName = ""
    var languageId = 0L
    var fandomImageId = 0L
    var fromAccountId = 0L
    var fromAccountImageId = 0L
    var fromAccountName = ""
    var fromAccountSex = 0L
    var banDate = 0L
    var dateCreate = 0L

    override fun json(inp: Boolean, json: Json): Json {
        id = json.m(inp, "id", id)
        ownerId = json.m(inp, "ownerId", ownerId)
        comment = json.m(inp, "comment", comment)
        fandomId = json.m(inp, "fandomId", fandomId)
        fandomName = json.m(inp, "fandomName", fandomName)
        languageId = json.m(inp, "languageId", languageId)
        fandomImageId = json.m(inp, "fandomImageId", fandomImageId)
        fromAccountId = json.m(inp, "fromAccountId", fromAccountId)
        fromAccountImageId = json.m(inp, "fromAccountImageId", fromAccountImageId)
        fromAccountName = json.m(inp, "fromAccountName", fromAccountName)
        fromAccountSex = json.m(inp, "fromAccountSex", fromAccountSex)
        banDate = json.m(inp, "banDate", banDate)
        dateCreate = json.m(inp, "dateCreate", dateCreate)
        return json
    }

    fun parseSupportString(supportString:String){
        val j = Json(supportString)
        comment = j.getString("comment")
        fromAccountId = j.getLong("fromAccountId")
        fromAccountImageId = j.getLong("fromAccountImageId")
        fromAccountName = j.getString("fromAccountName")
        fromAccountSex = j.getLong("fromAccountSex")
        banDate = j.getLong("banDate")
    }

}