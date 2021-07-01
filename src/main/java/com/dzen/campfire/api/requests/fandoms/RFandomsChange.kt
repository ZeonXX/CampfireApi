package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json


open class RFandomsChange(
        var fandomId: Long,
        var name: String?,
        var categoryId: Long?,
        var closed: Boolean?,
        var image:ByteArray?,
        var imageMini:ByteArray?,
        var params1: Array<Long>?,
        var params2: Array<Long>?,
        var params3: Array<Long>?,
        var params4: Array<Long>?
) : Request<RFandomsChange.Response>() {

    companion object {

        val E_BAD_IMG_WEIGHT = "E_BAD_IMG_WEIGHT"
        val E_BAD_IMG_MINI_WEIGHT = "E_BAD_IMG_MINI_WEIGHT"
        val E_BAD_IMG_SIZE = "E_BAD_IMG_SIZE"
        val E_BAD_IMG_MINI_SIZE = "E_BAD_IMG_MINI_SIZE"
        val E_BAD_NAME_L = "E_BAD_NAME_L"
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        name = json.mNull(inp, "name", name, String::class)
        categoryId = json.mNull(inp, "categoryId", categoryId, Long::class)
        closed = json.mNull(inp, "closed", closed, Boolean::class)
        image = json.mNull(inp, "image", image, ByteArray::class)
        imageMini = json.mNull(inp, "imageMini", imageMini, ByteArray::class)
        params1 = json.mNull(inp, "params1", params1, Array<Long>::class)
        params2 = json.mNull(inp, "params2", params2, Array<Long>::class)
        params3 = json.mNull(inp, "params3", params3, Array<Long>::class)
        params4 = json.mNull(inp, "params4", params4, Array<Long>::class)
    }

    override fun instanceResponse(json: Json): Response {
        return Response()
    }

    class Response : Request.Response() {

        override fun json(inp: Boolean, json: Json) {}

    }

}