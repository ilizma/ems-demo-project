package com.ilizma.dashboard.presentation.model

data class HistoricData(
    val buildingActivePower: Double,
    val gridActivePower: Double,
    val pvActivePower: Double,
    val quasarsActivePower: Double,
    val timestamp: String
)