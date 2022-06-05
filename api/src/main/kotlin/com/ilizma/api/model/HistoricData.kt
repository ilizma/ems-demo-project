package com.ilizma.api.model

import com.squareup.moshi.Json

data class HistoricData(
    @Json(name = "building_active_power")
    val buildingActivePower: Double,
    @Json(name = "grid_active_power")
    val gridActivePower: Double,
    @Json(name = "pv_active_power")
    val pvActivePower: Double,
    @Json(name = "quasars_active_power")
    val quasarsActivePower: Double,
    val timestamp: String,
)