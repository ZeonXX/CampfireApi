package com.dzen.campfire.api.models.publications.post

import com.dzen.campfire.api.API
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

class PageImages : Page() {

    var title = ""
    var imagesIds: Array<Long> = emptyArray()
    var imagesMiniIds: Array<Long> = emptyArray()
    var imagesMiniSizesW: Array<Int> = emptyArray()
    var imagesMiniSizesH: Array<Int> = emptyArray()
    var insertImages: Array<ByteArray?> = emptyArray()
    var insertImagesMini: Array<ByteArray?> = emptyArray()
    var imagesCount = 0

    var replacePageIndex = -1
    var removePageIndex = -1

    override fun getType() = API.PAGE_TYPE_IMAGES

    override fun isRemoveOnChange() = false

    override fun prepareForServer(page:Page){
        page as PageImages
        title = page.title
        insertImages = page.insertImages
        insertImagesMini = page.insertImagesMini
        removePageIndex = page.removePageIndex
        replacePageIndex = page.replacePageIndex
    }

    override fun fillResourcesList(list: ArrayList<Long>) {
        for (i in imagesIds) list.add(i)
        for (i in imagesMiniIds) list.add(i)
    }

    override fun addInsertData(request: Request<*>) {
        for (i in insertImages) request.addDataOutput(i)
        for (i in insertImagesMini) request.addDataOutput(i)
        imagesCount = insertImages.size
    }

    override fun restoreInsertData(request: Request<*>, offset:Int):Int {
        insertImages = Array(imagesCount) { request.dataOutput[it + offset] }
        insertImagesMini = Array(imagesCount) { request.dataOutput[it + offset + imagesCount] }
        return imagesCount/2
    }

    override fun json(inp: Boolean, json: Json): Json {
        title = json.m(inp, "title", title)
        imagesIds = json.m(inp, "imagesIds", imagesIds)
        imagesMiniIds = json.m(inp, "imagesMiniIds", imagesMiniIds)
        imagesMiniSizesW = json.m(inp, "imagesMiniSizesW", imagesMiniSizesW)
        imagesMiniSizesH = json.m(inp, "imagesMiniSizesH", imagesMiniSizesH)
        removePageIndex = json.m(inp, "removePageIndex", removePageIndex)
        replacePageIndex = json.m(inp, "replacePageIndex", replacePageIndex)
        imagesCount = json.m(inp, "imagesCount", imagesCount)
        return super.json(inp, json)
    }

}

