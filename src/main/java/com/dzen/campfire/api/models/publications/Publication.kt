package com.dzen.campfire.api.models.publications

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.models.fandoms.Fandom
import com.dzen.campfire.api.models.publications.post.PublicationPost
import com.dzen.campfire.api.models.publications.chat.PublicationChatMessage
import com.dzen.campfire.api.models.publications.events_admins.PublicationEventAdmin
import com.dzen.campfire.api.models.publications.events_fandoms.PublicationEventFandom
import com.dzen.campfire.api.models.publications.events_moderators.PublicationEventModer
import com.dzen.campfire.api.models.publications.events_user.PublicationEventUser
import com.dzen.campfire.api.models.publications.moderations.PublicationModeration
import com.dzen.campfire.api.models.publications.stickers.PublicationSticker
import com.dzen.campfire.api.models.publications.stickers.PublicationStickersPack
import com.dzen.campfire.api.models.publications.tags.PublicationTag
import com.sup.dev.java.libs.eventBus.EventBus
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable
import com.sup.dev.java.libs.json.JsonPolimorf
import com.sup.dev.java.tools.ToolsThreads

abstract class Publication : JsonPolimorf {

    var jsonDB: Json? = null

    var id = 0L
    var fandom = Fandom()
    var creator = Account()
    var category = 0L
    var dateCreate = 0L
    var publicationType = 0L
    var parentPublicationId = 0L
    var parentPublicationType = 0L
    var karmaCount = 0L
    var myKarma = 0L
    var status = 0L
    var closed = false
    var subPublicationsCount = 0L
    var reportsCount = 0L
    var important = 0L
    var tag_1 = 0L
    var tag_2 = 0L
    var tag_3 = 0L
    var tag_4 = 0L
    var tag_5 = 0L
    var tag_6 = 0L
    var tag_7 = 0L
    var tag_s_1 = ""
    var reactions:Array<Reaction> = emptyArray()

    //
    //  Getters
    //

    val isDraft: Boolean
        get() = status == API.STATUS_DRAFT

    val isPublic: Boolean
        get() = status == API.STATUS_PUBLIC

    constructor()

    constructor(jsonDB: Json) {
        this.jsonDB = jsonDB
    }

    init {
        publicationType = getPublicationTypeConst()
        ToolsThreads.main(100) { EventBus.post(EventPublicationInstance(this)) }
    }

    abstract fun getPublicationTypeConst(): Long

    override fun json(inp: Boolean, json: Json): Json {
        id = json.m(inp, "id", id)
        category = json.m(inp, "category", category)
        fandom = json.m(inp, "fandom", fandom)
        creator = json.m(inp, "creator", creator)
        dateCreate = json.m(inp, "dateCreate", dateCreate)
        publicationType = json.m(inp, "unitType", publicationType)
        parentPublicationId = json.m(inp, "parentUnitId", parentPublicationId)
        parentPublicationType = json.m(inp, "parentUnitType", parentPublicationType)
        karmaCount = json.m(inp, "karmaCount", karmaCount)
        myKarma = json.m(inp, "myKarma", myKarma)
        status = json.m(inp, "status", status)
        closed = json.m(inp, "closed", closed)
        subPublicationsCount = json.m(inp, "subUnitsCount", subPublicationsCount)
        reportsCount = json.m(inp, "reportsCount", reportsCount)
        important = json.m(inp, "important", important)
        tag_1 = json.m(inp, "tag_1", tag_1)
        tag_2 = json.m(inp, "tag_2", tag_2)
        tag_3 = json.m(inp, "tag_3", tag_3)
        tag_4 = json.m(inp, "tag_4", tag_4)
        tag_5 = json.m(inp, "tag_5", tag_5)
        tag_6 = json.m(inp, "tag_6", tag_6)
        tag_7 = json.m(inp, "tag_7", tag_7)
        tag_s_1 = json.m(inp, "tag_s_1", tag_s_1)
        jsonDB = json.mNull(inp, "jsonDB", jsonDB, Json::class)

        //  Обратная совместимость
        json.m(inp, "creatorId", creator.id)
        json.m(inp, "creatorImageId", creator.imageId)
        json.m(inp, "creatorSex", creator.sex)
        json.m(inp, "creatorName", creator.name)
        json.m(inp, "creatorLvl", creator.lvl)
        json.m(inp, "creatorKarma30", creator.karma30)
        json.m(inp, "creatorLastOnlineTime", creator.lastOnlineDate)
        json.m(inp, "fandomId", fandom.id)
        json.m(inp, "fandomName", fandom.name)
        json.m(inp, "fandomImageId", fandom.imageId)
        json.m(inp, "fandomKarmaCof", fandom.karmaCof)
        json.m(inp, "fandomClosed", fandom.closed)
        json.m(inp, "languageId", fandom.languageId)

        jsonPublication(inp, json)
        if (!inp) restoreFromJsonDB()

        return json
    }

    fun restoreFromJsonDB() {
        if (jsonDB != null) {
            jsonDB(false, jsonDB!!)
            jsonDB = null
        }
    }

    fun getResourcesList(): ArrayList<Long> {
        val list = ArrayList<Long>()
        fillResourcesList(list)
        return list
    }

    open fun fillResourcesList(list: ArrayList<Long>) {

    }

    protected open fun jsonPublication(inp: Boolean, json: Json) {

    }

    fun jsonDB(inp: Boolean, json: Json): Json {
        val j = jsonDBLocal(inp, json)
        reactions = j.m(inp, "reactions", reactions)
        return j
    }

    open fun jsonDBLocal(inp: Boolean, json: Json): Json {
        return json
    }

    companion object {

        @JvmStatic
        fun instance(json: Json): Publication {
            return instance(json, json.get<Long>("unitType")!!)
        }

        @JvmStatic
        fun instance(type: Long): Publication {
            return when (type) {
                API.PUBLICATION_TYPE_COMMENT -> PublicationComment()
                API.PUBLICATION_TYPE_POST -> PublicationPost()
                API.PUBLICATION_TYPE_CHAT_MESSAGE -> PublicationChatMessage()
                API.PUBLICATION_TYPE_TAG -> PublicationTag()
                API.PUBLICATION_TYPE_MODERATION -> PublicationModeration()
                API.PUBLICATION_TYPE_EVENT_USER -> PublicationEventUser()
                API.PUBLICATION_TYPE_EVENT_MODER -> PublicationEventModer()
                API.PUBLICATION_TYPE_EVENT_ADMIN -> PublicationEventAdmin()
                API.PUBLICATION_TYPE_EVENT_FANDOM -> PublicationEventFandom()
                API.PUBLICATION_TYPE_STICKERS_PACK -> PublicationStickersPack()
                API.PUBLICATION_TYPE_STICKER -> PublicationSticker()
                else -> PublicationUnknown()
            }
        }

        @JvmStatic
        fun instance(json: Json, type: Long): Publication {
            val publication: Publication = instance(type)
            publication.json(false, json)
            return publication
        }
    }

    class Reaction(
            var accountId:Long,
            var reactionIndex:Long
    ): JsonParsable {

        constructor() : this(0,0)

        override fun json(inp: Boolean, json: Json): Json {
            accountId = json.m(inp, "accountId", accountId)
            reactionIndex = json.m(inp, "reactionIndex", reactionIndex)
            return json
        }

    }

}