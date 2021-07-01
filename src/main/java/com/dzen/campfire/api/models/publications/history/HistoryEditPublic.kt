package com.dzen.campfire.api.models.publications.history

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class HistoryEditPublic : History {

    var oldText = ""

    override fun getType() = API.HISTORY_PUBLICATION_TYPE_EDIT_PUBLIC

    constructor()

    constructor(userId:Long,
                userImageId:Long,
                userName:String,
                oldText:String =""
    ):super(userId, userImageId, userName, ""){
        this.oldText = oldText
    }

    override fun json(inp: Boolean, json: Json): Json {
        oldText = json.m(inp, "oldText", oldText)
        return super.json(inp, json)
    }
}