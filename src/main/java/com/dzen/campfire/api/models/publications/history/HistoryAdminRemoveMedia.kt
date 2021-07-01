package com.dzen.campfire.api.models.publications.history

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class HistoryAdminRemoveMedia : History {

    override fun getType() = API.HISTORY_PUBLICATION_TYPE_ADMIN_REMOVE_MEDIA

    constructor()

    constructor(userId:Long,
                userImageId:Long,
                userName:String,
                comment:String
    ):super(userId, userImageId, userName, comment){

    }

    override fun json(inp: Boolean, json: Json): Json {
        return super.json(inp, json)
    }
}