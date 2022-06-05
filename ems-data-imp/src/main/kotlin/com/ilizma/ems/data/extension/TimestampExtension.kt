package com.ilizma.ems.data.extension

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

fun String.getFormattedDate(
): String = toInstant()
    .toLocalDateTime(TimeZone.currentSystemDefault())
    .toString()
    .replace(oldValue = "T", newValue = " ")