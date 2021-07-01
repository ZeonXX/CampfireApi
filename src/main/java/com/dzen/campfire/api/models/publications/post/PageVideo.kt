package com.dzen.campfire.api.models.publications.post

import com.dzen.campfire.api.API
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

class PageVideo: Page() {

    var videoId = ""
    var imageId = 0L
    var w = 0
    var h = 0
    var insertBytes: ByteArray? = null

    override fun getType() = API.PAGE_TYPE_VIDEO

    override fun addInsertData(request: Request<*>) {
        request.addDataOutput(insertBytes)
    }

    override fun restoreInsertData(request: Request<*>, offset:Int):Int {
        insertBytes = request.dataOutput[0]
        return 1
    }

    override fun json(inp: Boolean, json: Json): Json {
        videoId = json.m(inp, "videoId", videoId)
        imageId = json.m(inp, "imageId", imageId)
        w = json.m(inp, "J_W", w)
        h = json.m(inp, "J_H", h)
        return super.json(inp, json)
    }

    override fun fillResourcesList(list: ArrayList<Long>) {
        list.add(imageId)
    }


}
