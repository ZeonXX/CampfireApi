package com.dzen.campfire.api.models.publications.events_fandoms

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.Publication
import com.sup.dev.java.libs.json.Json

class PublicationEventFandom : Publication {

    var event: ApiEventFandom? = null

    override fun getPublicationTypeConst() = API.PUBLICATION_TYPE_EVENT_FANDOM

    constructor()

    constructor(event: ApiEventFandom) {
        this.event = event
    }

    constructor(jsonDB: Json) : super(jsonDB) {    restoreFromJsonDB()}

    override fun jsonPublication(inp: Boolean, json: Json) {}

    override fun jsonDBLocal(inp: Boolean, json: Json): Json {
        event = json.mNull(inp, "event", event, ApiEventFandom::class)
        return json
    }

    override fun fillResourcesList(list: ArrayList<Long>) {
        if(event != null) event!!.fillResourcesList(list)
    }


}