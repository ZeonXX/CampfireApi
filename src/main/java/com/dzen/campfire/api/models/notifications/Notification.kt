package com.dzen.campfire.api.models.notifications

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.notifications.account.*
import com.dzen.campfire.api.models.notifications.activities.NotificationActivitiesRelayRaceLost
import com.dzen.campfire.api.models.notifications.activities.NotificationActivitiesNewPost
import com.dzen.campfire.api.models.notifications.activities.NotificationActivitiesRelayRaceTurn
import com.dzen.campfire.api.models.notifications.activities.NotificationActivitiesRelayRejected
import com.dzen.campfire.api.models.notifications.chat.*
import com.dzen.campfire.api.models.notifications.comments.NotificationComment
import com.dzen.campfire.api.models.notifications.comments.NotificationCommentAnswer
import com.dzen.campfire.api.models.notifications.fandom.*
import com.dzen.campfire.api.models.notifications.post.*
import com.dzen.campfire.api.models.notifications.project.*
import com.dzen.campfire.api.models.notifications.rubrics.*
import com.dzen.campfire.api.models.notifications.publications.*
import com.dzen.campfire.api.models.notifications.translates.NotificationTranslatesAccepted
import com.dzen.campfire.api.models.notifications.translates.NotificationTranslatesRejected
import com.sup.dev.java.libs.debug.log
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonPolimorf

abstract class Notification : JsonPolimorf {

    companion object {

        private val J_N_TYPE = "J_N_TYPE"

        @JvmStatic
        fun instance(json: Json): Notification {

            val type: Long = json.getLong(J_N_TYPE)
            val notification: Notification

            when (type) {
                API.NOTIF_COMMENT -> notification = NotificationComment()
                API.NOTIF_COMMENT_ANSWER -> notification = NotificationCommentAnswer()
                API.NOTIF_KARMA_ADD -> notification = NotificationKarmaAdd()
                API.NOTIF_ACCOUNT_FOLLOWS_ADD -> notification = NotificationAccountsFollowsAdd()
                API.NOTIF_ACHI -> notification = NotificationAchievement()
                API.NOTIF_CHAT_MESSAGE -> notification = NotificationChatMessage()
                API.NOTIF_FOLLOWS_PUBLICATION -> notification = NotificationFollowsPublication()
                API.NOTIF_CHAT_MESSAGE_CHANGE -> notification = NotificationChatMessageChange()
                API.NOTIF_CHAT_MESSAGE_REMOVE -> notification = NotificationChatMessageRemove()
                API.NOTIF_CHAT_MESSAGE_ANSWER -> notification = NotificationChatAnswer()
                API.NOTIF_CHAT_TYPING -> notification = NotificationChatTyping()
                API.NOTIF_PUBLICATION_BLOCK -> notification = NotificationPublicationBlock()
                API.NOTIF_FANDOM_ACCPTED -> notification = NotificationFandomAccepted()
                API.NOTIF_QUEST_POGRESS -> notification = NotificationQuestProgress()
                API.NOTIF_PUBLICATION_IMPORTANT -> notification = NotificationPublicationImportant()
                API.NOTIF_MODERATION_TO_DRAFTS -> notification = NotificationModerationToDraft()
                API.NOTIF_PROJECT_AB_PARAMS_CHAGED -> notification = NotificationProjectABParamsChanged()
                API.NOTIF_MODERATION_POST_TAGS -> notification = NotificationModerationPostTags()
                API.NOTIF_MODERATION_FORGIVE -> notification = NotificationForgive()
                API.NOTIF_CHAT_READ -> notification = NotificationChatRead()
                API.NOTIF_BLOCK -> notification = NotificationAdminBlock()
                API.NOTIF_FANDOM_MAKE_MODERATOR -> notification = NotificationFandomMakeModerator()
                API.NOTIF_FANDOM_REMOVE_MODERATOR -> notification = NotificationFandomRemoveModerator()
                API.NOTIF_PUNISHMENT_REMOVE -> notification = NotificationPunishmentRemove()
                API.NOTIF_PUBLICATION_RESTORE -> notification = NotificationPublicationRestore()
                API.NOTIF_MODERATION_REJECTED -> notification = NotificationModerationRejected()
                API.NOTIF_ADMIN_STATUS_REMOVE -> notification = NotificationAdminStatusRemove()
                API.NOTIF_ADMIN_DESCRIPTION_REMOVE -> notification = NotificationAdminDescriptionRemove()
                API.NOTIF_ADMIN_LINK_REMOVE -> notification = NotificationAdminLinkRemove()
                API.NOTIF_ADMIN_NAME_REMOVE -> notification = NotificationAdminNameRemove()
                API.NOTIF_ADMIN_POST_FANDOM_CHANGE -> notification = NotificationAdminPostFandomChange()
                API.NOTIF_PUBLICATION_BLOCK_AFTER_REPORT -> notification = NotificationPublicationBlockAfterReport()
                API.NOTIF_MENTION -> notification = NotificationMention()
                API.NOTIF_MODERATION_MULTILINGUAL_NOT -> notification = NotificationModerationMultilingualNot()
                API.NOTIF_QUEST_FINISH -> notification = NotificationQuestFinish()
                API.NOTIF_MODERATION_POST_CLOSE -> notification = NotificationModerationPostClosed()
                API.NOTIF_MODERATION_POST_CLOSE_NO -> notification = NotificationModerationPostClosedNo()
                API.NOTIF_RUBRICS_CHANGE_NAME  -> notification = NotificationRubricsChangeName()
                API.NOTIF_RUBRICS_CHANGE_OWNER -> notification = NotificationRubricsChangeOwner()
                API.NOTIF_RUBRICS_MAKE_OWNER -> notification = NotificationRubricsMakeOwner()
                API.NOTIF_RUBRICS_REMOVE -> notification = NotificationRubricsRemove()
                API.NOTIF_RUBRICS_KARMA_COF_CHANGED -> notification = NotificationRubricsKarmaCofChanged()
                API.NOTIF_RUBRICS_MOVE_FANDOM -> notification = NotificationRubricsMoveFandom()
                API.NOTIF_PUBLICATION_REACTION -> notification = NotificationPublicationReaction()
                API.NOTIF_ACTIVITIES_RELAY_RACE_TURN -> notification = NotificationActivitiesRelayRaceTurn()
                API.NOTIF_ACTIVITIES_RELAY_RACE_LOST -> notification = NotificationActivitiesRelayRaceLost()
                API.NOTIF_ACTIVITIES_NEW_POST -> notification = NotificationActivitiesNewPost()
                API.NOTIF_ACTIVITIES_RELAY_RACE_REJECTED -> notification = NotificationActivitiesRelayRejected()
                API.NOTIF_FANDOM_VICEROY_ASSIGN -> notification = NotificationFandomViceroyAssign()
                API.NOTIF_FANDOM_VICEROY_REMOVE -> notification = NotificationFandomViceroyRemove()
                API.NOTIF_ALIVE -> notification = NotificationAlive()
                API.NOTIF_DONATE -> notification = NotificationDonate()
                API.NOTIF_EFFECT_ADD -> notification = NotificationEffectAdd()
                API.NOTIF_EFFECT_REMOVE -> notification = NotificationEffectRemove()
                API.NOTIF_TRANSLATE_ACCEPTED -> notification = NotificationTranslatesAccepted()
                API.NOTIF_TRANSLATE_REJECTED -> notification = NotificationTranslatesRejected()
                API.NOTIF_ADMIN_POST_MEDIA_REMOVE -> notification = NotificationAdminPostRemoveMedia()
                API.NOTIF_FANDOM_REMOVE_CANCEL -> notification = NotificationFandomRemoveCancel()
                API.NOTIF_ACCOUNT_ADMIN_VOTE_CANCELED_FOR_USER -> notification = NotificationAccountAdminVoteCanceledForUser()
                API.NOTIF_ACCOUNT_ADMIN_VOTE_CANCELED_FOR_ADMIN -> notification = NotificationAccountAdminVoteCanceledForAdmin()

                else -> notification = NotificationUnknown()
            }

            notification.json(false, json)
            return notification
        }
    }

    var id = 0L
    var status = 0L
    var dateCreate = 0L
    var imageId = 0L
    var randomCode = 0L

    constructor() {

    }

    constructor(imageId: Long) {
        this.imageId = imageId
    }

    fun getResourcesList(): ArrayList<Long> {
        val list = ArrayList<Long>()
        if (imageId != 0L) list.add(imageId)
        fillResourcesList(list)
        return list
    }

    abstract fun fillResourcesList(list: ArrayList<Long>)

    override fun json(inp: Boolean, json: Json): Json {

        id = json.m(inp, "J_N_ID", id)
        status = json.m(inp, "status", status)
        dateCreate = json.m(inp, "J_N_DATE_CREATE", dateCreate)
        imageId = json.m(inp, "J_N_IMAGE_ID", imageId)
        randomCode = json.m(inp, "randomCode", randomCode)

        if (inp) json.put(J_N_TYPE, getType())

        return json
    }

    abstract fun getType(): Long

    abstract fun isShadow(): Boolean

    abstract fun isNeedForcePush(): Boolean

}
