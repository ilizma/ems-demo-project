package com.ilizma.api.extension

import android.content.Context
import java.io.IOException

fun Context.getJsonStringFromAsset(
    fileName: String,
): String = try {
    assets
        .open(fileName)
        .bufferedReader()
        .use { it.readText() }
} catch (e: IOException) {
    throw e
}