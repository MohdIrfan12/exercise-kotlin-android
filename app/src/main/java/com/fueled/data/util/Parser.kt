package com.fueled.data.util

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.reflect.Type
import java.nio.charset.Charset
import java.util.stream.Collectors

object Parser {

    val gson = GsonBuilder().create()

    inline fun <reified T> parseJson(jsonString: String): T =
        gson.fromJson(jsonString, type<T>())

    inline fun <reified T> type(): Type = object : TypeToken<T>() {}.type
}