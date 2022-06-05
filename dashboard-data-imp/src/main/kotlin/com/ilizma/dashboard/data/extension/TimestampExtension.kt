package com.ilizma.dashboard.data.extension

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

fun String.getFormattedDate(
): String = toInstant()
    .toLocalDateTime(TimeZone.currentSystemDefault())
    .toString()
    .replace("T", " ")