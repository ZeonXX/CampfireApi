package com.dzen.campfire.api.models.publications.events_moderators

import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonPolimorf

abstract class ApiEventModer : JsonPolimorf {

    var ownerAccountId = 0L
    var ownerAccountImageId = 0L
    var ownerAccountName = ""
    var ownerAccountSex = 0L
    var targetAccountId = 0L
    var targetAccountImageId = 0L
    var targetAccountName = ""
    var targetAccountSex = 0L
    var comment = ""

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long
    ) : this(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            "")

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                comment: String
    ) : this(ownerAccountId,
            ownerAccountName,
            ownerAccountImageId,
            ownerAccountSex,
            0, "", 0, 0, comment)

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                targetAccountId: Long,
                targetAccountName: String,
                targetAccountImageId: Long,
                targetAccountSex: Long,
                comment: String) : super() {
        this.ownerAccountId = ownerAccountId
        this.ownerAccountImageId = ownerAccountImageId
        this.ownerAccountName = ownerAccountName
        this.ownerAccountSex = ownerAccountSex
        this.targetAccountId = targetAccountId
        this.targetAccountImageId = targetAccountImageId
        this.targetAccountName = targetAccountName
        this.targetAccountSex = targetAccountSex
        this.comment = comment
    }

    override fun json(inp: Boolean, json: Json): Json {
        if (inp) json.put("type", getType())
        ownerAccountId = json.m(inp, "ownerAccountId", ownerAccountId)
        ownerAccountName = json.m(inp, "ownerAccountName", ownerAccountName)
        ownerAccountImageId = json.m(inp, "ownerAccountImageId", ownerAccountImageId)
        ownerAccountSex = json.m(inp, "ownerAccountSex", ownerAccountSex)
        targetAccountId = json.m(inp, "targetAccountId", targetAccountId)
        targetAccountName = json.m(inp, "targetAccountName", targetAccountName)
        targetAccountImageId = json.m(inp, "targetAccountImageId", targetAccountImageId)
        targetAccountSex = json.m(inp, "targetAccountSex", targetAccountSex)
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
        fun instance(json: Json): ApiEventModer {

            val event = when ( json.get<Long>("type")!!) {
                else -> ApiEventModerUnknown()
            }

            event.json(false, json)
            return event
        }
    }

}