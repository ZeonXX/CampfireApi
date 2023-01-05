package com.dzen.campfire.api.models.publications.post

import com.dzen.campfire.api.API
import com.dzen.campfire.api.tools.client.Request
import com.dzen.campfire.api.tools.server.IControllerResources
import com.sup.dev.java.libs.json.Json

class PageLinkImage : Page() {

    var imageId = 0L
    var link = ""
    var insertBytes: ByteArray? = null

    override fun getType() = API.PAGE_TYPE_LINK_IMAGE

    override fun json(inp: Boolean, json: Json): Json {
        link = json.m(inp, "link", link)
        imageId = json.m(inp, "imageId", imageId)

        return super.json(inp, json)
    }

    override fun copyChangeData(page: Page) {
        super.copyChangeData(page)
        if(page is PageLinkImage) {
            if(insertBytes == null) this.imageId = page.imageId
        }
    }

    override fun fillResourcesList(list: ArrayList<Long>) {
        list.add(imageId)
    }

    override fun addInsertData(request: Request<*>) {
        request.addDataOutput(insertBytes)
    }

    override fun duplicateResources(res: IControllerResources, unitId: Long) {
        if (imageId > 0) imageId = res.put(res.get(imageId), unitId)
    }

    override fun restoreInsertData(request: Request<*>, offset: Int): Int {
        insertBytes = request.dataOutput[offset]
        return 1
    }

}

