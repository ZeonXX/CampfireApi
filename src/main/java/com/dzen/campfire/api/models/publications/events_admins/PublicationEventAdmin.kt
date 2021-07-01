package com.dzen.campfire.api.models.publications.events_admins

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.Publication
import com.sup.dev.java.libs.json.Json

class PublicationEventAdmin : Publication {

    var event: ApiEventAdmin? = null

    override fun getPublicationTypeConst() = API.PUBLICATION_TYPE_EVENT_ADMIN

    constructor()

    constructor(event: ApiEventAdmin) {
        this.event = event
    }

    constructor(jsonDB: Json) : super(jsonDB) {    restoreFromJsonDB()}

    override fun jsonPublication(inp: Boolean, json: Json) {}

    override fun jsonDBLocal(inp: Boolean, json: Json): Json {
        event = json.mNull(inp, "event", event, ApiEventAdmin::class)
        return json
    }

    override fun fillResourcesList(list: ArrayList<Long>) {
        if(event != null) event!!.fillResourcesList(list)
    }


}

