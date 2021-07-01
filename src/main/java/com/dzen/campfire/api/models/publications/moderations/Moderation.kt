package com.dzen.campfire.api.models.publications.moderations

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.publications.moderations.activities.ModerationActivitiesChange
import com.dzen.campfire.api.models.publications.moderations.activities.ModerationActivitiesCreate
import com.dzen.campfire.api.models.publications.moderations.activities.ModerationActivitiesRemove
import com.dzen.campfire.api.models.publications.moderations.fandom.*
import com.dzen.campfire.api.models.publications.moderations.chat.ModerationChatChange
import com.dzen.campfire.api.models.publications.moderations.chat.ModerationChatCreate
import com.dzen.campfire.api.models.publications.moderations.chat.ModerationChatRemove
import com.dzen.campfire.api.models.publications.moderations.posts.*
import com.dzen.campfire.api.models.publications.moderations.rubrics.ModerationRubricChangeName
import com.dzen.campfire.api.models.publications.moderations.rubrics.ModerationRubricChangeOwner
import com.dzen.campfire.api.models.publications.moderations.rubrics.ModerationRubricCreate
import com.dzen.campfire.api.models.publications.moderations.rubrics.ModerationRubricRemove
import com.dzen.campfire.api.models.publications.moderations.tags.*
import com.dzen.campfire.api.models.publications.moderations.publications.ModerationBlock
import com.dzen.campfire.api.models.publications.moderations.publications.ModerationForgive
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonPolimorf


abstract class Moderation : JsonPolimorf {

    var comment: String = ""

    override fun json(inp: Boolean, json: Json): Json {
        comment = json.m(inp, "comment", comment)
        if (inp) json.put("type", getType())
        return json
    }

    constructor() {

    }

    constructor(comment: String) {
        this.comment = comment
    }

    abstract fun fillResourcesList(list: ArrayList<Long>)

    abstract fun getType():Long

    companion object {

        //
        //  Static
        //

        @JvmStatic
        fun instance(json: Json): Moderation {
            val type = json.get<Long>("type")!!
            val page: Moderation
            page = when (type) {
                API.MODERATION_TYPE_BLOCK -> ModerationBlock()
                API.MODERATION_TYPE_TAG_CREATE -> ModerationTagCreate()
                API.MODERATION_TYPE_TAG_CHANGE -> ModerationTagChange()
                API.MODERATION_TYPE_TAG_REMOVE -> ModerationTagRemove()
                API.MODERATION_TYPE_DESCRIPTION -> ModerationDescription()
                API.MODERATION_TYPE_GALLERY_ADD -> ModerationGalleryAdd()
                API.MODERATION_TYPE_GELLERY_REMOVE -> ModerationGalleryRemove()
                API.MODERATION_TYPE_TITLE_IMAGE -> ModerationTitleImage()
                API.MODERATION_TYPE_IMPORTANT -> ModerationImportant()
                API.MODERATION_TYPE_LINK_ADD -> ModerationLinkAdd()
                API.MODERATION_TYPE_LINK_REMOVE -> ModerationLinkRemove()
                API.MODERATION_TYPE_TO_DRAFTS -> ModerationToDrafts()
                API.MODERATION_TYPE_POST_TAGS -> ModerationPostTags()
                API.MODERATION_TYPE_NAMES -> ModerationNames()
                API.MODERATION_TYPE_FORGIVE -> ModerationForgive()
                API.MODERATION_TYPE_BACKGROUND_IMAGE -> ModerationBackgroundImage()
                API.MODERATION_TYPE_CHAT_CREATE -> ModerationChatCreate()
                API.MODERATION_TYPE_CHAT_CHANGE -> ModerationChatChange()
                API.MODERATION_TYPE_CHAT_REMOVE -> ModerationChatRemove()
                API.MODERATION_TYPE_TAG_MOVE -> ModerationTagMove()
                API.MODERATION_TYPE_TAG_MOVE_BETWEEN_CATEGORY -> ModerationTagMoveBetweenCategory()
                API.MODERATION_TYPE_TAG_PIN_POST_IN_FANDOM -> ModerationPinPostInFandom()
                API.MODERATION_TYPE_MULTILINGUAL_NOT -> ModerationMultilingualNot()
                API.MODERATION_TYPE_POST_CLSOE -> ModerationPostClose()
                API.MODERATION_TYPE_POST_CLSOE_NO -> ModerationPostCloseNo()
                API.MODERATION_TYPE_RUBRIC_CHANGE_NAME -> ModerationRubricChangeName()
                API.MODERATION_TYPE_RUBRIC_CHANGE_OWNER -> ModerationRubricChangeOwner()
                API.MODERATION_TYPE_RUBRIC_CREATE -> ModerationRubricCreate()
                API.MODERATION_TYPE_RUBRIC_REMOVE -> ModerationRubricRemove()
                API.MODERATION_TYPE_BACKGROUND_IMAGE_SUB -> ModerationBackgroundImageSub()
                API.MODERATION_TYPE_ACTIVITIES_CREATE -> ModerationActivitiesCreate()
                API.MODERATION_TYPE_ACTIVITIES_CHANGE -> ModerationActivitiesChange()
                API.MODERATION_TYPE_ACTIVITIES_REMOVE -> ModerationActivitiesRemove()
                API.MODERATION_TYPE_LINK_CHANGE -> ModerationLinkChange()
                else -> ModerationUnknown()
            }

            page.json(false, json)
            return page
        }
    }

}