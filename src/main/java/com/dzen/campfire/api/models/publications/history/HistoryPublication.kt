package com.dzen.campfire.api.models.publications.history

import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class HistoryPublication : JsonParsable {

    var id = 0L
    var publicationId = 0L
    var date = 0L
    var history: History

    constructor() {
        history = HistoryUnknown()
    }

    constructor(publicationId: Long,
                history: History
    ) {
        this.publicationId = publicationId
        this.history = history
    }

    override fun json(inp: Boolean, json: Json): Json {
        id = json.m(inp, "id", id)
        publicationId = json.m(inp, "unitId", publicationId)
        date = json.m(inp, "date", date)
        if (inp) {
            json.m(inp, "history", history)
        } else {
            val j = json.getJson("history")
            if(j != null) history = History.instance(j)
        }
        return json
    }

}