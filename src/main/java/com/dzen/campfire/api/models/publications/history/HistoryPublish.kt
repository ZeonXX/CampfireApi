package com.dzen.campfire.api.models.publications.history

import com.dzen.campfire.api.API

class HistoryPublish : History {


    override fun getType() = API.HISTORY_PUBLICATION_TYPE_PUBLISH

    constructor()

    constructor(userId:Long,
                userImageId:Long,
                userName:String
    ):super(userId, userImageId, userName, ""){

    }
}