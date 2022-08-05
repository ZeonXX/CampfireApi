package com.dzen.campfire.api.models.publications.post

import com.dzen.campfire.api.API
import com.dzen.campfire.api.tools.client.Request
import com.dzen.campfire.api.tools.server.IControllerResources
import com.sup.dev.java.libs.json.Json

class PageDownload : Page() {

    var resourceId = 0L
    var title = ""
    var patch = ""
    var size = 0L
    var autoUnzip = false

    var insertBytes: ByteArray? = null

    override fun getType() = API.PAGE_TYPE_DOWNLOAD

    override fun fillResourcesList(list: ArrayList<Long>) {
        list.add(resourceId)
    }

    override fun addInsertData(request: Request<*>) {
        request.addDataOutput(insertBytes)
    }

    override fun duplicateResources(res: IControllerResources, unitId: Long) {
        if (resourceId > 0) resourceId = res.put(res.get(resourceId), unitId)
    }

    override fun restoreInsertData(request: Request<*>, offset:Int):Int {
        insertBytes = request.dataOutput[offset]
        return 1
    }

    override fun json(inp: Boolean, json: Json): Json {
        resourceId = json.m(inp, "resourceId", resourceId)
        title = json.m(inp, "title", title)
        patch = json.m(inp, "patch", patch)
        size = json.m(inp, "size", size)
        autoUnzip = json.m(inp, "autoUnzip", autoUnzip)
        return super.json(inp, json)
    }

}
