package com.dzen.campfire.api.models.quests

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.Publication
import com.sup.dev.java.libs.json.Json

class QuestDetails : Publication {
    override fun getPublicationTypeConst(): Long = API.PUBLICATION_TYPE_QUEST

    constructor()

    constructor(jsonDB: Json) : super(jsonDB) {
        restoreFromJsonDB()
    }

    override fun jsonPublication(inp: Boolean, json: Json) {}

    var title = ""
    var description = ""
    var showSource = true
    var variables: Array<QuestVariable> = emptyArray()
        set(value) {
            field = value
            variablesMap = null // invalidate
        }

    var variablesMap: Map<Long, QuestVariable>? = null
        get() {
            if (field != null) return field
            else {
                field = variables.associateBy { it.id }
            }
            return field
        }
        private set

    override fun jsonDBLocal(inp: Boolean, json: Json): Json {
        title = json.m(inp, "title", title)
        description = json.m(inp, "description", description)
        showSource = json.m(inp, "showSource", showSource)
        variables = json.m(inp, "variables", variables, Array<QuestVariable>::class)
        return json
    }
}
