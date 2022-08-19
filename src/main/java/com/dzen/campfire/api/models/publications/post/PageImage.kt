package com.dzen.campfire.api.models.publications.post

import com.dzen.campfire.api.API
import com.dzen.campfire.api.tools.client.Request
import com.dzen.campfire.api.tools.server.IControllerResources
import com.sup.dev.java.libs.json.Json

class PageImage : Page() {

    var imageId = 0L
    var gifId = 0L
    var w = 0
    var h = 0
    var insertBytes: ByteArray? = null
    var insertGifBytes: ByteArray? = null

    override fun getType() = API.PAGE_TYPE_IMAGE

    override fun fillResourcesList(list: ArrayList<Long>) {
        list.add(imageId)
        list.add(gifId)
    }

    override fun addInsertData(request: Request<*>) {
        request.addDataOutput(insertBytes)
        request.addDataOutput(insertGifBytes)
    }

    override fun restoreInsertData(request: Request<*>, offset: Int): Int {
        insertBytes = request.dataOutput[offset]
        insertGifBytes = request.dataOutput[offset + 1]
        return 2
    }

    override fun duplicateResources(res: IControllerResources, unitId: Long) {
        if (imageId > 0) imageId = res.put(res.get(imageId), unitId)
        if (gifId > 0) gifId = res.put(res.get(gifId), unitId)
    }

    override fun json(inp: Boolean, json: Json): Json {
        imageId = json.m(inp, "J_IMAGE_ID", imageId)
        w = json.m(inp, "J_W", w)
        h = json.m(inp, "J_H", h)
        gifId = json.m(inp, "gifId", gifId)
        return super.json(inp, json)
    }


    fun getMainImageId() = if (gifId == 0L) imageId else gifId

}
