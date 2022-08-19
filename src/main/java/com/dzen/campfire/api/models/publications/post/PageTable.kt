package com.dzen.campfire.api.models.publications.post

import com.dzen.campfire.api.API
import com.dzen.campfire.api.tools.client.Request
import com.dzen.campfire.api.tools.server.IControllerResources
import com.sup.dev.java.libs.json.Json
import com.sup.dev.java.libs.json.JsonParsable

class PageTable : Page() {

    companion object {
        val CELL_TYPE_TEXT = 1L
        val CELL_TYPE_IMAGE = 2L
    }

    var title = ""
    var columnsCount = 0
    var rowsCount = 0
    var cells: Array<Cell> = emptyArray()

    override fun getType() = API.PAGE_TYPE_TABLE

    override fun json(inp: Boolean, json: Json): Json {
        columnsCount = json.m(inp, "columnsCount", columnsCount)
        rowsCount = json.m(inp, "rowsCount", rowsCount)
        title = json.m(inp, "title", title)
        cells = json.m(inp, "cells", cells)
        return super.json(inp, json)
    }

    override fun addInsertData(request: Request<*>) {
        for(c in cells) if(c.insertImage != null) c.insertImageIndex =  request.addDataOutput(c.insertImage)
    }

    override fun restoreInsertData(request: Request<*>, offset:Int):Int {
        var count = 0
        for(c in cells) if(c.insertImageIndex != -1){
            c.insertImage =  request.dataOutput[c.insertImageIndex]
            c.insertImageIndex = -1
            count++
        }
        return count
    }

    override fun duplicateResources(res: IControllerResources, unitId: Long) {
        for (c in cells) if (c.imageId > 0) {
            c.imageId = res.put(res.get(c.imageId), unitId)
        }
    }

    override fun fillResourcesList(list: ArrayList<Long>) {
        for (c in cells) if (c.imageId > 0) list.add(c.imageId)
    }

    fun getCell(rowIndex:Int, columnIndex:Int):Cell?{
        for(c in cells) if(c.rowIndex == rowIndex && c.columnIndex == columnIndex) return c
        return null
    }

    override fun isRemoveOnChange(): Boolean = false

    override fun prepareForServer(page: Page) {
        page as PageTable
        columnsCount = page.columnsCount
        rowsCount = page.rowsCount
        title = page.title
        cells = page.cells
    }

    class Cell : JsonParsable {

        var rowIndex = 0
        var columnIndex = 0
        var text = ""
        var imageId = 0L
        var type = 0L

        var insertImage:ByteArray? = null
        var insertImageIndex = -1

        override fun json(inp: Boolean, json: Json): Json {
            rowIndex = json.m(inp, "rowIndex", rowIndex)
            columnIndex = json.m(inp, "columnIndex", columnIndex)
            type = json.m(inp, "type", type)
            imageId = json.m(inp, "imageId", imageId)
            text = json.m(inp, "text", text)
            insertImageIndex = json.m(inp, "insertImageIndex", insertImageIndex)
            return json
        }

    }


}
