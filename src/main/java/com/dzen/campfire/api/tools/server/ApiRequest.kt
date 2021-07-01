package com.dzen.campfire.api.tools.server

import java.lang.annotation.Inherited

@Inherited
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class ApiRequest