package com.dzen.campfire.api.models.publications.events_fandoms

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonPolimorf

abstract class ApiEventFandom : JsonPolimorf {

    var fandomId = 0L
    var fandomName = ""
    var fandomImageId = 0L
    var ownerAccountId = 0L
    var ownerAccountImageId = 0L
    var ownerAccountName = ""
    var ownerAccountSex = 0L
    var comment = ""

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                fandomId: Long,
                fandomName: String,
                fandomImageId: Long,
                comment: String) : super() {
        this.fandomId = fandomId
        this.fandomName = fandomName
        this.fandomImageId = fandomImageId
        this.ownerAccountId = ownerAccountId
        this.ownerAccountImageId = ownerAccountImageId
        this.ownerAccountName = ownerAccountName
        this.ownerAccountSex = ownerAccountSex
        this.comment = comment
    }

    override fun json(inp: Boolean, json: Json): Json {
        if (inp) json.put("type", getType())
        fandomId = json.m(inp, "fandomId", fandomId)
        fandomImageId = json.m(inp, "fandomImageId", fandomImageId)
        fandomName = json.m(inp, "fandomName", fandomName)
        ownerAccountId = json.m(inp, "ownerAccountId", ownerAccountId)
        ownerAccountName = json.m(inp, "ownerAccountName", ownerAccountName)
        ownerAccountImageId = json.m(inp, "ownerAccountImageId", ownerAccountImageId)
        ownerAccountSex = json.m(inp, "ownerAccountSex", ownerAccountSex)
        comment = json.m(inp, "comment", comment)
        return json
    }

    abstract fun getType(): Long

    abstract fun fillResourcesList(list: ArrayList<Long>)

    companion object {

        //
        //  Static
        //

        @JvmStatic
        fun instance(json: Json): ApiEventFandom {

            val event = when ( json.get<Long>("type")!!) {
                API.PUBLICATION_EVENT_FANDOM_ACCEPTED -> ApiEventFandomAccepted()
                API.PUBLICATION_EVENT_FANDOM_CHANGE_CATEGORY -> ApiEventFandomChangeCategory()
                API.PUBLICATION_EVENT_FANDOM_RENAME -> ApiEventFandomRename()
                API.PUBLICATION_EVENT_FANDOM_CHANGE_AVATAR -> ApiEventFandomChangeAvatar()
                API.PUBLICATION_EVENT_FANDOM_CHANGE_PARAMS -> ApiEventFandomChangeParams()
                API.PUBLICATION_EVENT_FANDOM_CLOSE -> ApiEventFandomClose()
                API.PUBLICATION_EVENT_FANDOM_MAKE_MODERATOR  -> ApiEventFandomMakeModerator()
                API.PUBLICATION_EVENT_FANDOM_REMOVE -> ApiEventFandomRemove()
                API.PUBLICATION_EVENT_FANDOM_REMOVE_MODERATOR  -> ApiEventFandomRemoveModerator()
                API.PUBLICATION_EVENT_FANDOM_KARMA_COF_CHANGED -> ApiEventFandomCofChanged()
                API.PUBLICATION_EVENT_FANDOM_VICEROY_ASSIGN -> ApiEventFandomViceroyAssign()
                API.PUBLICATION_EVENT_FANDOM_VICEROY_REMOVE -> ApiEventFandomViceroyRemove()
                else -> ApiEventFandomUnknown()
            }

            event.json(false, json)
            return event
        }
    }

}