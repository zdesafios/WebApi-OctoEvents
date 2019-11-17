package com.octoevents

import com.google.gson.GsonBuilder
import com.octoevents.app.AppStarter
import com.octoevents.hook.app.config.AppModules
import io.javalin.Javalin
import io.javalin.plugin.json.FromJsonMapper
import io.javalin.plugin.json.JavalinJson
import io.javalin.plugin.json.ToJsonMapper
import org.koin.core.context.startKoin

fun main(args: Array<String>) {
    startKoin {
        fileProperties()
        printLogger()
        modules(AppModules.allModules)
    }

    JavalinJson.fromJsonMapper = object: FromJsonMapper {
        val gson = GsonBuilder().create()
        override  fun <T> map(json: String, targetClass: Class<T>) = gson.fromJson(json, targetClass)
    }

    JavalinJson.toJsonMapper = object : ToJsonMapper {
        val gson = GsonBuilder().create()
        override fun map(obj: Any): String = gson.toJson(obj)
    }

    val app = Javalin.create().start(8000)
    AppStarter().router.register(app)

}

