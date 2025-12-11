package com.thopkins.pythonpocket

import android.content.Context
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

data class Lesson(
    val id: String,
    val title: String,
    val text: String,
    val example: String?,
    val starterCode: String?,
    val level: String = "beginner"
)

object LessonLoader {

    fun loadAll(ctx: Context): List<Lesson> {
        val assets = ctx.assets
        val list = mutableListOf<Lesson>()
        val files = assets.list("lessons") ?: arrayOf()
        files.sorted().forEach { name ->
            try {
                val input = assets.open("lessons/$name")
                val json = input.bufferedReader().use(BufferedReader::readText)
                val obj = JSONObject(json)
                list.add(fromJson(obj))
            } catch (e: Exception) {
                // ignore malformed lesson
            }
        }
        return list
    }

    fun load(ctx: Context, id: String): Lesson? {
        val assets = ctx.assets
        val fname = if (id.endsWith(".json")) id else "$id.json"
        return try {
            val input = assets.open("lessons/$fname")
            val json = input.bufferedReader().use(BufferedReader::readText)
            fromJson(JSONObject(json))
        } catch (e: Exception) {
            null
        }
    }

    private fun fromJson(obj: JSONObject): Lesson {
        return Lesson(
            id = obj.optString("id"),
            title = obj.optString("title"),
            text = obj.optString("text"),
            example = obj.optString("example", null),
            starterCode = obj.optString("starter_code", obj.optString("starter_code", null)),
            level = obj.optString("level", "beginner")
        )
    }
}
