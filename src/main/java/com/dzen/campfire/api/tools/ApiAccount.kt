package com.dzen.campfire.api.tools

class ApiAccount(
        var id: Long = 0,
        var imageId: Long = 0,
        var name: String = "null",
        var accessTag: Long=0,
        var accessTagSub: Long=0,
        var sex: Long=0,
        var settings: String="",
        var accessToken: String? = null,
        var refreshToken: String? = null,
        var refreshTokenDateCreate: Long? = null,
        var lastOnlineTime: Long=0,
){

    var tag_s_1 = ""

}