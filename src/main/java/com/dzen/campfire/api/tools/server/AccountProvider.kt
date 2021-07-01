package com.dzen.campfire.api.tools.server

import com.dzen.campfire.api.tools.ApiAccount
import com.sup.dev.java.classes.collections.Cash
import com.sup.dev.java.classes.items.Item2
import com.dzen.campfire.api.tools.client.ApiClient
import com.sup.dev.java.tools.ToolsMath

abstract class AccountProvider {

    private val accessCash: Cash<String, Item2<ApiAccount, Long>> = Cash(10000)

    open fun getAccount(accessToken: String?, refreshToken: String?, loginToken: String?): ApiAccount? {

        if (loginToken != null && loginToken.isNotEmpty()) {
            return loginByLogin(loginToken)
        } else if (refreshToken != null && refreshToken.isNotEmpty()) {
            return loginByRefresh(refreshToken)
        } else if (accessToken != null && accessToken.isNotEmpty()) {
            return loginByAccess(accessToken)
        } else return null

    }

    open fun getAccount(accountId: Long): ApiAccount? {
        for(a in accessCash.getItemsCopy()) if(a?.a1?.id == accountId) return a.a1
        return null
    }

    open fun getAccounts(accountId: Long): ArrayList<ApiAccount> {
        val accounts = ArrayList<ApiAccount>()
        for(a in accessCash.getItemsCopy()) if(a?.a1?.id == accountId) accounts.add(a.a1)
        return accounts
    }

    fun clearCash(accessToken: String) {
        accessCash.put(accessToken, null)
    }

    fun clearCash(accountId: Long) {
        accessCash.lock {
            val remveList = ArrayList<String>()
            for (i in accessCash.keySet()) {
                val x = accessCash[i]
                if (x != null && x.a1.id == accountId) remveList.add(i)
            }
            for (i in remveList) accessCash.put(i, null)
        }
    }

    private fun loginByLogin(token: String): ApiAccount? {
        val account = getByLoginToken(token)
        if (account == null) return null

        updateAccessTokens(account)
        if (account.refreshToken == null) updateRefreshToken(account)
        onAccountLoaded(account)

        return account
    }

    private fun loginByRefresh(token: String): ApiAccount? {
        val account = getByRefreshToken(token)
        if (account == null) return null

        updateAccessTokens(account)
        onAccountLoaded(account)

        return account
    }

    open fun loginByAccess(token: String): ApiAccount? {
        val byAccessToken = getByAccessToken(token)
        if (byAccessToken != null) return byAccessToken

        val pair = accessCash[token]
        if (pair == null) return null
        if (pair.a2 + ApiClient.TOKEN_ACCESS_LIFETIME < System.currentTimeMillis()) return null

        onAccountLoaded(pair.a1)

        return pair.a1
    }

    private fun updateAccessTokens(account: ApiAccount) {
        account.accessToken = createToken(account)
        accessCash.put(account.accessToken!!, Item2(account, System.currentTimeMillis()))
    }

    private fun updateRefreshToken(account: ApiAccount) {
        account.refreshToken = createToken(account)
        setRefreshToken(account, account.refreshToken!!)
    }

    private fun createToken(account: ApiAccount): String {
        var token = "" + account.id + "_"
        for (i in token.length until ApiClient.TOKEN_REFRESH_SIZE)
            token += ApiClient.TOKEN_CHARS[ToolsMath.randomInt(0, ApiClient.TOKEN_CHARS.length - 1)]
        return token
    }

    protected open fun onAccountLoaded(account: ApiAccount) {

    }

    protected open fun getByAccessToken(token: String?): ApiAccount? {
        return null
    }

    protected abstract fun getByRefreshToken(token: String): ApiAccount?

    protected abstract fun setRefreshToken(account: ApiAccount, refreshToken: String)

    protected abstract fun getByLoginToken(token: String?): ApiAccount?

}