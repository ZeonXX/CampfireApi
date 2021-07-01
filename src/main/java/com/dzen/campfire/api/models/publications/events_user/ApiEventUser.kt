package com.dzen.campfire.api.models.publications.events_user

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonPolimorf

abstract class ApiEventUser : JsonPolimorf {

    var comment = ""
    var ownerAccountId = 0L
    var ownerAccountImageId = 0L
    var ownerAccountName = ""
    var ownerAccountSex = 0L
    var adminAccountId = 0L
    var adminAccountName = ""
    var adminAccountImageId = 0L
    var adminAccountSex = 0L

    constructor()

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                comment:String) : super() {
        this.ownerAccountId = ownerAccountId
        this.ownerAccountImageId = ownerAccountImageId
        this.ownerAccountName = ownerAccountName
        this.ownerAccountSex = ownerAccountSex
        this.comment = comment
    }

    constructor(ownerAccountId: Long,
                ownerAccountName: String,
                ownerAccountImageId: Long,
                ownerAccountSex: Long,
                adminAccountId: Long,
                adminAccountName: String,
                adminAccountImageId: Long,
                adminAccountSex: Long,
                comment:String) : super() {
        this.ownerAccountId = ownerAccountId
        this.ownerAccountImageId = ownerAccountImageId
        this.ownerAccountName = ownerAccountName
        this.ownerAccountSex = ownerAccountSex
        this.adminAccountId = adminAccountId
        this.adminAccountName = adminAccountName
        this.adminAccountImageId = adminAccountImageId
        this.adminAccountSex = adminAccountSex
        this.comment = comment
    }

    override fun json(inp: Boolean, json: Json): Json {
        if (inp) json.put("type", getType())
        ownerAccountId = json.m(inp, "ownerAccountId", ownerAccountId)
        ownerAccountName = json.m(inp, "ownerAccountName", ownerAccountName)
        ownerAccountImageId = json.m(inp, "ownerAccountImageId", ownerAccountImageId)
        ownerAccountSex = json.m(inp, "ownerAccountSex", ownerAccountSex)
        adminAccountId = json.m(inp, "adminAccountId", adminAccountId)
        adminAccountName = json.m(inp, "adminAccountName", adminAccountName)
        adminAccountImageId = json.m(inp, "adminAccountImageId", adminAccountImageId)
        adminAccountSex = json.m(inp, "adminAccountSex", adminAccountSex)
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
        fun instance(json: Json): ApiEventUser {
            val event = when (json.get<Long>("type")!!) {
                API.PUBLICATION_EVENT_USER_ACHIEVEMENT -> ApiEventUserAchievement()
                API.PUBLICATION_EVENT_USER_FANDOM_SUGGEST -> ApiEventUserFandomSuggest()
                API.PUBLICATION_EVENT_USER_ADMIN_BANED -> ApiEventUserAdminBaned()
                API.PUBLICATION_EVENT_USER_ADMIN_WARNED -> ApiEventUserAdminWarned()
                API.PUBLICATION_EVENT_USER_ADMIN_NAME_CHANGED -> ApiEventUserAdminNameChanged()
                API.PUBLICATION_EVENT_USER_ADMIN_REMOVE_PUNISHMENT -> ApiEventUserAdminPunishmentRemove()
                API.PUBLICATION_EVENT_USER_ADMIN_REMOVE_DESCRIPTION -> ApiEventUserAdminRemoveDescription()
                API.PUBLICATION_EVENT_USER_ADMIN_REMOVE_LINK -> ApiEventUserAdminRemoveLink()
                API.PUBLICATION_EVENT_USER_ADMIN_REMOVE_STATUS -> ApiEventUserAdminRemoveStatus()
                API.PUBLICATION_EVENT_USER_ADMIN_REMOVE_IMAGE -> ApiEventUserAdminRemoveImage()
                API.PUBLICATION_EVENT_USER_ADMIN_REMOVE_NAME -> ApiEventUserAdminRemoveName()
                API.PUBLICATION_EVENT_USER_ADMIN_REMOVE_TITLE_IMAGE -> ApiEventUserAdminRemoveTitleImage()
                API.PUBLICATION_EVENT_USER_ADMIN_MAKE_MODER -> ApiEventUserFandomMakeModerator()
                API.PUBLICATION_EVENT_USER_ADMIN_REMOVE_MODER -> ApiEventUserFandomRemoveModerator()
                API.PUBLICATION_EVENT_USER_ADMIN_MODERATION_REJECTED -> ApiEventUserAdminModerationRejected()
                API.PUBLICATION_EVENT_USER_ADMIN_PUBLICATION_RESTORED -> ApiEventUserAdminPublicationRestored()
                API.PUBLICATION_EVENT_USER_ADMIN_POST_CHANGE_FANDOM -> ApiEventUserAdminPostChangeFandom()
                API.PUBLICATION_EVENT_USER_ADMIN_PUBLICATION_BLOCKED -> ApiEventUserAdminPublicationBlocked()
                API.PUBLICATION_EVENT_USER_QUEST_FINISH -> ApiEventUserQuestFinish()
                API.PUBLICATION_EVENT_USER_ADMIN_VICEROY_ASSIGN-> ApiEventUserAdminViceroyAssign()
                API.PUBLICATION_EVENT_USER_ADMIN_VICEROY_REMOVE -> ApiEventUserAdminViceroyRemove()
                API.PUBLICATION_EVENT_USER_EFFECT_ADD -> ApiEventUserEffectAdd()
                API.PUBLICATION_EVENT_USER_EFFECT_REMOVE -> ApiEventUserEffectRemove()
                API.PUBLICATION_EVENT_USER_TRANSLATE_REJECTED -> ApiEventUserAdminTranslateRejected()
                API.PUBLICATION_EVENT_USER_ADMIN_POST_REMOVE_MEDIA -> ApiEventUserAdminPostRemoveMedia()
                API.PUBLICATION_EVENT_USER_ADMIN_VOTE_CANCELED_FOR_ADMIN -> ApiEventUserAdminVoteCanceledForAdmin()
                API.PUBLICATION_EVENT_USER_ADMIN_VOTE_CANCELED_FOR_USER -> ApiEventUserAdminVoteCanceledForUser()
                else -> ApiEventUserUnknown()
            }

            event.json(false, json)
            return event
        }
    }

}