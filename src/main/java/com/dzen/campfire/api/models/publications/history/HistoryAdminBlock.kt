package com.dzen.campfire.api.models.publications.history

import com.dzen.campfire.api.API

class HistoryAdminBlock : History {

    override fun getType() = API.HISTORY_PUBLICATION_TYPE_ADMIN_BLOCK

    constructor()

    constructor(userId:Long,
                userImageId:Long,
                userName:String,
                comment:String
    ):super(userId, userImageId, userName, comment){

    }
}