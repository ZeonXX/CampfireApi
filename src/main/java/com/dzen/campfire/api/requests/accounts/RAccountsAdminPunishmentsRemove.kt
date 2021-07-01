package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsAdminPunishmentsRemove(
        var punishmentId:Long,
        var comment:String
) : Request<RAccountsAdminPunishmentsRemove.Response>() {

    override fun jsonSub(inp: Boolean, json: Json) {
        punishmentId = json.m(inp, "punishmentId", punishmentId)
        comment = json.m(inp, "comment", comment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var fandomId = 0L
        var languageId = 0L
        var newBlockDate = 0L

        constructor(json: Json) {
            json(false, json)
        }

        constructor(fandomId:Long, languageId:Long, newBlockDate:Long){
            this.fandomId = fandomId
            this.languageId = languageId
            this.newBlockDate = newBlockDate
        }

        override fun json(inp: Boolean, json: Json) {
            fandomId = json.m(inp, "fandomId", fandomId)
            languageId = json.m(inp, "languageId", languageId)
            newBlockDate = json.m(inp, "newBlockDate", newBlockDate)
        }

    }


}
