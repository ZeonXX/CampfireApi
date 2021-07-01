@file:Suppress("UNCHECKED_CAST")

package com.dzen.campfire.api.tools.server

import com.sup.dev.java.libs.anatations.ToolsAnatations
import com.dzen.campfire.api.tools.client.Request
import com.sup.dev.java.libs.debug.err
import com.sup.dev.java.libs.debug.info
import com.sup.dev.java.libs.debug.log
import com.sup.dev.java.libs.json.Json
import java.io.File
import java.lang.ClassCastException
import java.lang.reflect.Constructor
import java.lang.reflect.InvocationTargetException
import java.util.HashMap
import kotlin.reflect.KClass


class RequestFactory(
        val jarName: String?,
        val srcPatch: String?
) {

    private val requests = HashMap<String, Constructor<out Request<*>>>()
    private val supportNamesMapper = HashMap<String, String>()

    init {
        val list = ArrayList<Class<*>>()
        if (jarName != null) list.addAll(ToolsAnatations.findAnnotatedClasses(ApiRequest::class.java, File(jarName)))
        if (srcPatch != null) list.addAll(ToolsAnatations.findAnnotatedClasses(ApiRequest::class.java, File(srcPatch)))

        for (c in list) {
            try {
                add(c as Class<out Request<*>>)
            } catch (e: ClassCastException) {

            }
        }
    }

    fun addOldName(oldName: String, newName: String) {
        supportNamesMapper[oldName] = newName
    }

    protected fun add(e: KClass<out Request<*>>) {
        add(e.java)
    }

    protected fun add(e: Class<out Request<*>>) {
        try {
            requests[e.superclass.simpleName] = e.getConstructor()
        } catch (e: Throwable) {
            err(e)
        }

    }

    fun instanceRequest(json: Json): Request<*> {
        try {
            val requestNameArray = json.get<String>(Request.J_REQUEST_NAME)!!.split(".")
            val requestName = requestNameArray[requestNameArray.size - 1]
            try {

                var constructor = requests[requestName]
                if (constructor == null) {
                    val newName = supportNamesMapper[requestName]
                    if (newName != null) {
                        info("Name is mapped [$requestName] -> [$newName]")
                        constructor = requests[newName]
                    }
                }
                if (constructor == null) throw IllegalArgumentException("Request with name [$requestName] not found")

                val request = constructor.newInstance()
                request.json(false, json)

                return request

            } catch (e: InstantiationException) {
                err("Can't instance request [$requestName]")
                throw RuntimeException(e)
            } catch (e: InvocationTargetException) {
                err("Can't instance request [$requestName]")
                throw RuntimeException(e)
            } catch (e: IllegalAccessException) {
                err("Can't instance request [$requestName]")
                throw RuntimeException(e)
            }

        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException(e)
        }

    }

}
