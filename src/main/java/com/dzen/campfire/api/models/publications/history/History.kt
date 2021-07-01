package com.dzen.campfire.api.models.publications.history

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

abstract class History : JsonParsable {

    var userId = 0L
    var userImageId = 0L
    var userName = ""
    var comment = ""

    constructor(){

    }

    constructor(userId:Long,
                userImageId:Long,
                userName:String,
                comment:String
    ){
        this.userId = userId
        this.userImageId = userImageId
        this.userName = userName
        this.comment = comment
    }

    abstract fun getType():Long

    override fun json(inp: Boolean, json: Json): Json {
        userId = json.m(inp, "userId", userId)
        userImageId = json.m(inp, "userImageId", userImageId)
        userName = json.m(inp, "userName", userName)
        comment = json.m(inp, "comment", comment)
        json.m(inp, "type", getType())
        return json
    }

    companion object {

        fun instance(json: Json): History {

            val history = when (json.get<Long>("type")!!) {
                API.HISTORY_PUBLICATION_TYPE_CREATED -> HistoryCreate()
                API.HISTORY_PUBLICATION_TYPE_ADMIN_BACK_DRAFT -> HistoryAdminBackDraft()
                API.HISTORY_PUBLICATION_TYPE_ADMIN_BLOCK -> HistoryAdminBlock()
                API.HISTORY_PUBLICATION_TYPE_ADMIN_CHANGE_FANDOM  -> HistoryAdminChangeFandom()
                API.HISTORY_PUBLICATION_TYPE_ADMIN_CLEAR_REPORTS  -> HistoryAdminClearReports()
                API.HISTORY_PUBLICATION_TYPE_ADMIN_DEEP_BLOCK -> HistoryAdminDeepBlock()
                API.HISTORY_PUBLICATION_TYPE_ADMIN_NOT_BLOCK  -> HistoryAdminNotBlock()
                API.HISTORY_PUBLICATION_TYPE_ADMIN_NOT_MULTILINGUAL -> HistoryAdminNotMultilingual()
                API.HISTORY_PUBLICATION_TYPE_BACK_DRAFT -> HistoryBackDraft()
                API.HISTORY_PUBLICATION_TYPE_CHANGE_FANDOM -> HistoryChangeFandom()
                API.HISTORY_PUBLICATION_TYPE_EDIT_PUBLIC -> HistoryEditPublic()
                API.HISTORY_PUBLICATION_TYPE_MULTILINGUAL -> HistoryMultilingual()
                API.HISTORY_PUBLICATION_TYPE_NOT_MULTILINGUAL -> HistoryNotMultolingual()
                API.HISTORY_PUBLICATION_TYPE_PUBLISH -> HistoryPublish()
                API.HISTORY_PUBLICATION_TYPE_ADMIN_CHANGE_TAGS -> HistoryAdminChangeTags()
                API.HISTORY_PUBLICATION_TYPE_ADMIN_IMPORTANT -> HistoryAdminImportant()
                API.HISTORY_PUBLICATION_TYPE_ADMIN_NOT_IMPORTANT -> HistoryAdminNotImportant()
                API.HISTORY_PUBLICATION_TYPE_ADMIN_PIN_FANDOM -> HistoryAdminPinFandom()
                API.HISTORY_PUBLICATION_TYPE_ADMIN_UNPIN_FANDOM -> HistoryAdminUnpinFandom()
                API.HISTORY_PUBLICATION_TYPE_CHANGE_TAGS -> HistoryChangeTags()
                API.HISTORY_PUBLICATION_TYPE_PIN_PROFILE -> HistoryPinProfile()
                API.HISTORY_PUBLICATION_TYPE_UNPIN_PROFILE -> HistoryUnpinProfile()
                API.HISTORY_PUBLICATION_TYPE_ADMIN_NOT_DEEP_BLOCK -> HistoryAdminNotDeepBlock()
                API.HISTORY_PUBLICATION_TYPE_CLOSE -> HistoryClose()
                API.HISTORY_PUBLICATION_TYPE_ADMIN_CLOSE -> HistoryAdminClose()
                API.HISTORY_PUBLICATION_TYPE_CLOSE_NO -> HistoryCloseNo()
                API.HISTORY_PUBLICATION_TYPE_ADMIN_CLOSE_NO -> HistoryAdminCloseNo()
                API.HISTORY_PUBLICATION_TYPE_ADMIN_REMOVE_MEDIA -> HistoryAdminRemoveMedia()
                else -> HistoryUnknown()
            }

            history.json(false, json)
            return history
        }
    }
}