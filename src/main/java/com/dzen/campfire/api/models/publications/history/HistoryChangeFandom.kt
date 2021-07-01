package com.dzen.campfire.api.models.publications.history

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class HistoryChangeFandom : History {

    var oldFandomId = 0L
    var oldFandomName = ""
    var newFandomId = 0L
    var newFandomName = ""


    override fun getType() = API.HISTORY_PUBLICATION_TYPE_CHANGE_FANDOM

    constructor()

    constructor(userId: Long,
                userImageId: Long,
                userName: String,
                oldFandomId: Long,
                oldFandomName: String,
                newFandomId: Long,
                newFandomName: String
    ) : super(userId, userImageId, userName, "") {
        this.oldFandomId = oldFandomId
        this.oldFandomName = oldFandomName
        this.newFandomId = newFandomId
        this.newFandomName = newFandomName
    }

    override fun json(inp: Boolean, json: Json): Json {
        oldFandomId = json.m(inp, "oldFandomId", oldFandomId)
        oldFandomName = json.m(inp, "oldFandomName", oldFandomName)
        newFandomId = json.m(inp, "newFandomId", newFandomId)
        newFandomName = json.m(inp, "newFandomName", newFandomName)
        return super.json(inp, json)
    }
}