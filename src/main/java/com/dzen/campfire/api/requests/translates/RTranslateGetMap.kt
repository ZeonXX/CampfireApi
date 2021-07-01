package com.dzen.campfire.api.requests.translates

import com.dzen.campfire.api.models.translate.Translate
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RTranslateGetMap(
        var languageId: Long
) : Request<RTranslateGetMap.Response>() {

    init {
        tokenRequired = false
        tokenDesirable = false
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        languageId = json.m(inp, "languageId", languageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var translate_language_id = 0L
        var translate_map: HashMap<String, Translate> = HashMap()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(translate_language_id: Long,
                translate_map: HashMap<String, Translate>) {
            this.translate_language_id = translate_language_id
            this.translate_map = translate_map
        }

        override fun json(inp: Boolean, json: Json) {
            translate_language_id = json.m(inp, "translate_language_id", translate_language_id)
            if (inp) {
                json.m(inp, "translate_map_k", translate_map.keys.toTypedArray())
                json.m(inp, "translate_map_v", translate_map.values.toTypedArray())
            } else {
                translate_map = HashMap()
                val translate_map_k = json.m(inp, "translate_map_k", translate_map.keys.toTypedArray())
                val translate_map_v = json.m(inp, "translate_map_v", translate_map.values.toTypedArray())
                for (i in translate_map_k.indices) translate_map[translate_map_k[i]] = translate_map_v[i]
            }
        }

    }

}