package com.dzen.campfire.api.requests.publications

import com.dzen.campfire.api.models.publications.PublicationReport
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RPublicationsReportsGetAll(
        var publicationId: Long,
        var offset: Long
) : Request<RPublicationsReportsGetAll.Response>() {

    companion object {
        val COUNT = 20
    }

    init {
        cashAvailable = false
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        publicationId = json.m(inp, "publicationId", publicationId)
        offset = json.m(inp, "offset", offset)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var reports: Array<PublicationReport> = emptyArray()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(reports: Array<PublicationReport>) {
            this.reports = reports
        }

        override fun json(inp: Boolean, json: Json) {
            reports = json.m(inp, "reports", reports, Array<PublicationReport>::class)
        }

    }

}