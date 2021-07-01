package com.dzen.campfire.api.models.publications

import com.dzen.campfire.api.API
import com.sup.dev.java.libs.json.Json

class PublicationComment : Publication {

    companion object {

        val TYPE_TEXT = 0L
        val TYPE_IMAGE = 3L
        val TYPE_GIF = 4L
        val TYPE_IMAGES = 5L
        val TYPE_STICKER = 6L

    }

    var parentCommentId = 0L
    var type = 0L
    var quoteId = 0L
    var quoteText = ""
    var quoteImages: Array<Long> = emptyArray()
    var changed = false
    var quoteStickerId = 0L
    var quoteStickerImageId = 0L
    var quoteCreatorName = ""
    var answerName = ""

    //  TYPE_TEXT
    var text = ""
    //  TYPE_IMAGE
    var imageId = 0L
    var gifId = 0L
    var imageW = 0
    var imageH = 0
    //  TYPE_IMAGES
    var imageIdArray: Array<Long> = emptyArray()
    var imageWArray: Array<Int> = emptyArray()
    var imageHArray: Array<Int> = emptyArray()
    //  TYPE_STICKER
    var stickerId = 0L
    var stickerImageId = 0L
    var stickerGifId = 0L

    override fun getPublicationTypeConst() = API.PUBLICATION_TYPE_COMMENT

    constructor()

    constructor(jsonDB: Json) : super(jsonDB) {
        restoreFromJsonDB()
    }

    override fun jsonPublication(inp: Boolean, json: Json) {

    }

    override fun jsonDBLocal(inp: Boolean, json: Json): Json {
        text = json.m(inp, "J_TEXT", text)
        parentCommentId = json.m(inp, "J_PARENT_COMMENT_ID", parentCommentId)
        quoteId = json.m(inp, "quoteId", quoteId)
        quoteText = json.m(inp, "quoteText", quoteText)
        quoteImages = json.m(inp, "quoteImages", quoteImages)
        changed = json.m(inp, "changed", changed)
        quoteStickerId = json.m(inp, "quoteStickerId", quoteStickerId)
        quoteStickerImageId = json.m(inp, "quoteStickerImageId", quoteStickerImageId)
        quoteCreatorName = json.m(inp, "quoteCreatorName", quoteCreatorName)
        answerName = json.m(inp, "answerName", answerName)

        if (inp) json.put("type", type)
        else type = json.getLong("type", TYPE_TEXT)

        imageId = json.m(inp, "imageId", imageId)
        gifId = json.m(inp, "gifId", gifId)
        imageW = json.m(inp, "imageW", imageW)
        imageH = json.m(inp, "imageH", imageH)

        imageIdArray = json.m(inp, "imageIdArray", imageIdArray)
        imageWArray = json.m(inp, "imageWArray", imageWArray)
        imageHArray = json.m(inp, "imageHArray", imageHArray)

        stickerId = json.m(inp, "stickerId", stickerId)
        stickerImageId = json.m(inp, "stickerImageId", stickerImageId)
        stickerGifId = json.m(inp, "stickerGifId", stickerGifId)

        return json
    }

    override fun fillResourcesList(list: ArrayList<Long>) {
        list.add(imageId)
        list.add(gifId)
        for(i in imageIdArray) list.add(i)
    }


}
