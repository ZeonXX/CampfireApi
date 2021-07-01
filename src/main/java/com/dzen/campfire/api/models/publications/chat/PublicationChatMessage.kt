package com.dzen.campfire.api.models.publications.chat

import com.dzen.campfire.api.API
import com.dzen.campfire.api.models.chat.ChatTag
import com.dzen.campfire.api.models.publications.Publication
import com.sup.dev.java.libs.json.Json

class PublicationChatMessage : Publication {

    companion object {

        val TYPE_TEXT = 0L
        val TYPE_SYSTEM = 1L
        val TYPE_IMAGE = 3L
        val TYPE_GIF = 4L
        val TYPE_IMAGES = 5L
        val TYPE_VOICE = 6L
        val TYPE_STICKER = 7L

        val SYSTEM_TYPE_BLOCK = 1L
        val SYSTEM_TYPE_CREATE = 2L
        val SYSTEM_TYPE_ADD_USER = 3L
        val SYSTEM_TYPE_REMOVE_USER = 4L
        val SYSTEM_TYPE_CHANGE_IMAGE = 5L
        val SYSTEM_TYPE_CHANGE_NAME = 6L
        val SYSTEM_TYPE_LEAVE = 7L
        val SYSTEM_TYPE_ENTER = 8L
        val SYSTEM_TYPE_PARAMS = 9L
        val SYSTEM_TYPE_LEVEL = 10L
        val SYSTEM_TYPE_CHANGE_BACKGROUND = 11L

    }

    var type = 0L
    var chatType = 0L
    var quoteId = 0L
    var quoteText = ""
    var quoteImages:Array<Long> = emptyArray()
    var quoteStickerId = 0L
    var quoteStickerImageId = 0L
    var quoteCreatorName = ""
    var changed = false
    var randomTag = 0L
    var answerName = ""


    //  TYPE_TEXT
    var text: String = ""
    //  TYPE_IMAGE
    var resourceId = 0L
    var gifId = 0L
    var imageW = 0
    var imageH = 0
    //  TYPE_SYSTEM
    var systemType = 0L
    var systemOwnerId = 0L
    var systemOwnerSex = 0L
    var systemOwnerName = ""
    var systemTargetId = 0L
    var systemTargetName = ""
    var systemComment = ""
    var systemTag = 0L
    var blockModerationEventId = 0L
    var blockDate = 0L
    //  TYPE_IMAGES
    var imageIdArray: Array<Long> = emptyArray()
    var imageWArray: Array<Int> = emptyArray()
    var imageHArray: Array<Int> = emptyArray()
    //  TYPE_VOICE
    var voiceResourceId = 0L
    var voiceMs = 0L
    var voiceMask: Array<Int> = emptyArray()
    //  TYPE_STICKER
    var stickerId = 0L
    var stickerImageId = 0L
    var stickerGifId = 0L

    override fun getPublicationTypeConst() = API.PUBLICATION_TYPE_CHAT_MESSAGE

    constructor()

    constructor(jsonDB: Json) : super(jsonDB) {
        restoreFromJsonDB()
    }

    override fun fillResourcesList(list: ArrayList<Long>) {
        list.add(resourceId)
        list.add(gifId)
        list.add(voiceResourceId)
        for(i in imageIdArray) list.add(i)
    }

    override fun jsonPublication(inp: Boolean, json: Json) {

    }

    override fun jsonDBLocal(inp: Boolean, json: Json): Json {
        text = json.m(inp, "J_TEXT", text)

        if (inp) json.put("J_TYPE", type)
        else type = json.getLong("J_TYPE", TYPE_TEXT)

        resourceId = json.m(inp, "J_RESOURCE_ID", resourceId)
        gifId = json.m(inp, "gifId", gifId)
        imageW = json.m(inp, "J_IMAGE_W", imageW)
        imageH = json.m(inp, "J_IMAGE_H", imageH)
        chatType = json.m(inp, "chatType", chatType)
        quoteId = json.m(inp, "quoteId", quoteId)
        quoteText = json.m(inp, "quoteText", quoteText)
        quoteImages = json.m(inp, "quoteImages", quoteImages)
        changed = json.m(inp, "changed", changed)
        randomTag = json.m(inp, "randomTag", randomTag)
        answerName = json.m(inp, "answerName", answerName)
        quoteStickerId = json.m(inp, "quoteStickerId", quoteStickerId)
        quoteStickerImageId = json.m(inp, "quoteStickerImageId", quoteStickerImageId)
        quoteCreatorName = json.m(inp, "quoteCreatorName", quoteCreatorName)

        systemType = json.m(inp, "systemType", systemType)
        systemOwnerId = json.m(inp, "systemOwnerId", systemOwnerId)
        systemOwnerSex = json.m(inp, "systemOwnerSex", systemOwnerSex)
        systemOwnerName = json.m(inp, "systemOwnerName", systemOwnerName)
        systemTargetId = json.m(inp, "systemTargetId", systemTargetId)
        systemTargetName = json.m(inp, "systemTargetName", systemTargetName)
        systemComment = json.m(inp, "systemComment", systemComment)
        systemTag = json.m(inp, "systemTag", systemTag)
        blockModerationEventId = json.m(inp, "blockModerationEventId", blockModerationEventId)
        blockDate = json.m(inp, "blockDate", blockDate)

        imageIdArray = json.m(inp, "imageIdArray", imageIdArray)
        imageWArray = json.m(inp, "imageWArray", imageWArray)
        imageHArray = json.m(inp, "imageHArray", imageHArray)

        voiceResourceId = json.m(inp, "voiceResourceId", voiceResourceId)
        voiceMs = json.m(inp, "voiceMs", voiceMs)
        voiceMask = json.m(inp, "voiceMask", voiceMask)

        stickerId = json.m(inp, "stickerId", stickerId)
        stickerImageId = json.m(inp, "stickerImageId", stickerImageId)
        stickerGifId = json.m(inp, "stickerGifId", stickerGifId)

        return json
    }

    fun chatTag() = ChatTag(chatType, fandom.id, fandom.languageId)


}
