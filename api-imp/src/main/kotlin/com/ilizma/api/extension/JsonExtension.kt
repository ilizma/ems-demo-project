package com.ilizma.api.extension

import android.content.Context
import java.io.IOException

fun getJsonStringFromAsset(
    context: Context,
    fileName: String,
): String = try {
    context.assets
        .open(fileName)
        .bufferedReader()
        .use { it.readText() }
} catch (e: IOException) {
    throw e
}