package com.dzen.campfire.api.requests.fandoms

import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RFandomsAdminChangeImage(
        var fandomId: Long,
        var image: ByteArray?,
        var comment: String
) : Request<RFandomsAdminChangeImage.Response>() {

    init {
        addDataOutput(image)
    }

    override fun updateDataOutput() {
        image = dataOutput[0]
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        comment = json.m(inp, "comment", comment)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {



        constructor(json:Json){
            json(false, json)
        }

        constructor(){

        }

        override fun json(inp: Boolean, json: Json) {
        }

    }

}