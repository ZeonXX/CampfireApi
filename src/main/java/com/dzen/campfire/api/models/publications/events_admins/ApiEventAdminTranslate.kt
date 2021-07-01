package com.dzen.campfire.api.models.publications.events_admins

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.translate.TranslateHistory
import com.sup.dev.java.libs.json.Json

class ApiEventAdminTranslate : ApiEventAdmin {

    var history = TranslateHistory()

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                history: TranslateHistory
    ) : super(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            history.comment) {
        this.history = history
    }

    override fun getType() =  API.PUBLICATION_EVENT_ADMIN_TRANSLATE

    override fun json(inp: Boolean, json: Json): Json {
        history = json.m(inp, "history", history)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {

    }
}