package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RFandomsSuggest(
        var name: String,
        var categoryId: Long,
        var closed: Boolean,
        var image:ByteArray?,
        var imageMini:ByteArray?,
        var params1: Array<Long>,
        var params2: Array<Long>,
        var params3: Array<Long>,
        var params4: Array<Long>
) : Request<RFandomsSuggest.Response>() {

    companion object {
        val E_BAD_IMG_WEIGHT = "E_BAD_IMG_WEIGHT"
        val E_BAD_IMG_MINI_WEIGHT = "E_BAD_IMG_MINI_WEIGHT"
        val E_BAD_IMG_SIZE = "E_BAD_IMG_SIZE"
        val E_BAD_IMG_MINI_SIZE = "E_BAD_IMG_MINI_SIZE"
        val E_BAD_NAME_L = "E_BAD_NAME_L"
    }

    init {
        addDataOutput(image)
        addDataOutput(imageMini)
    }

    override fun updateDataOutput() {
        image = dataOutput[0]
        imageMini = dataOutput[1]
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        name = json.m(inp, "name", name)
        categoryId = json.m(inp, "categoryId", categoryId)
        closed = json.m(inp, "closed", closed)
        params1 = json.m(inp, "params1", params1)
        params2 = json.m(inp, "params2", params2)
        params3 = json.m(inp, "params3", params3)
        params4 = json.m(inp, "params4", params4)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {}

    }

}