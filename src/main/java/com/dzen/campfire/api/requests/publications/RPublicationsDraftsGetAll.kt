package com.dzen.campfire.api.requests.publications

import com.dzen.campfire.api.models.publications.Publication
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPublicationsDraftsGetAll(
        var fandomId:Long,
        var projectKey:String,
        var projectSubKey:String,
        var offset:Long
) : Request<RPublicationsDraftsGetAll.Response>() {

    companion object {
        val COUNT = 5
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        fandomId = json.m(inp, "fandomId", fandomId)
        projectKey = json.m(inp, "projectKey", projectKey)
        projectSubKey = json.m(inp, "projectSubKey", projectSubKey)
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var publications: Array<Publication> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(publications: Array<Publication>) {
            this.publications = publications
        }

        override fun json(inp: Boolean, json: Json) {
            publications = json.m(inp, "units", publications, Array<Publication>::class)
        }

    }

}