package com.ilizma.ems.data.model

data class HistoricData(
    val id: String,
    val buildingActivePower: Double,
    val gridActivePower: Double,
    val pvActivePower: Double,
    val quasarsActivePower: Double,
    val date: String,
)