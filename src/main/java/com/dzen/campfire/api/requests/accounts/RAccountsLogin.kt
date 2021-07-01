package com.dzen.campfire.api.requests.accounts

import com.dzen.campfire.api.models.translate.Translate
import com.dzen.campfire.api.models.account.Account
import com.dzen.campfire.api.models.account.AccountSettings
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.json.Json

open class RAccountsLogin(
        var tokenNotification: String,
        var languageId: Long
) : Request<RAccountsLogin.Response>() {

    init {
        tokenRequired = false
        tokenDesirable = true
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        tokenNotification = json.m(inp, "tokenNotification", tokenNotification)
        languageId = json.m(inp, "languageId", languageId)
    }

    override fun instanceResponse(json: Json): Response {
        return Response(json)
    }

    class Response : Request.Response {

        var version = ""
        var supportedVersion = emptyArray<String>()
        var supported = ""
        var protoadmins = emptyArray<Long>()
        var account: Account? = null
        var ABParams = Json()
        var hasSubscribes = false
        var translate_language_id = 0L
        var translate_map: HashMap<String, Translate> = HashMap()
        var translate_map_eng: HashMap<String, Translate> = HashMap()

        var serverTime = 0L
        var settings = AccountSettings()

        constructor(json: Json) {
            json(false, json)
        }

        constructor(version: String,
                    supported: String,
                    supportedVersion: Array<String>,
                    protoadmins: Array<Long>,
                    account: Account?,
                    settings: AccountSettings,
                    hasSubscribes: Boolean,
                    translate_language_id: Long,
                    translate_map: HashMap<String, Translate>,
                    translate_map_eng: HashMap<String, Translate>) {
            this.version = version
            this.supported = supported
            this.supportedVersion = supportedVersion
            this.protoadmins = protoadmins
            this.account = account
            this.serverTime = System.currentTimeMillis()
            this.settings = settings
            this.hasSubscribes = hasSubscribes
            this.translate_language_id = translate_language_id
            this.translate_map = translate_map
            this.translate_map_eng = translate_map_eng
        }

        override fun json(inp: Boolean, json: Json) {
            version = json.m(inp, "version", version)
            account = json.mNull(inp, "account", account, Account::class)
            supported = json.m(inp, "supported", supported)
            supportedVersion = json.m(inp, "supportedVersion", supportedVersion)
            protoadmins = json.m(inp, "protoadmins", protoadmins)
            serverTime = json.m(inp, "serverTime", serverTime)
            hasSubscribes = json.m(inp, "hasSubscribes", hasSubscribes)
            settings = json.m(inp, "settings", settings, AccountSettings::class)
            translate_language_id = json.m(inp, "translate_language_id", translate_language_id)

            if (inp) {
                json.m(inp, "translate_map_k", translate_map.keys.toTypedArray())
                json.m(inp, "translate_map_v", translate_map.values.toTypedArray())
                json.m(inp, "translate_map_eng_k", translate_map_eng.keys.toTypedArray())
                json.m(inp, "translate_map_eng_v", translate_map_eng.values.toTypedArray())
            } else {
                translate_map = HashMap()
                val translate_map_k = json.m(inp, "translate_map_k", translate_map.keys.toTypedArray())
                val translate_map_v = json.m(inp, "translate_map_v", translate_map.values.toTypedArray())
                for (i in translate_map_k.indices) translate_map[translate_map_k[i]] = translate_map_v[i]
                translate_map_eng = HashMap()
                val translate_map_eng_k = json.m(inp, "translate_map_eng_k", translate_map_eng.keys.toTypedArray())
                val translate_map_eng_v = json.m(inp, "translate_map_eng_v", translate_map_eng.values.toTypedArray())
                for (i in translate_map_eng_k.indices) translate_map_eng[translate_map_eng_k[i]] = translate_map_eng_v[i]
            }
        }

    }


}
