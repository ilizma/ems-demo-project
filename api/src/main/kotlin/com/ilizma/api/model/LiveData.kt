package com.ilizma.api.model

import com.squareup.moshi.Json

data class LiveData(
    @Json(name = "building_demand")
    val buildingDemand: Double,
    @Json(name = "current_energy")
    val currentEnergy: Double,
    @Json(name = "grid_power")
    val gridPower: Double,
    @Json(name = "quasars_power")
    val quasarsPower: Double,
    @Json(name = "solar_power")
    val solarPower: Double,
    @Json(name = "system_soc")
    val systemSoc: Double,
    @Json(name = "total_energy")
    val totalEnergy: Int,
)