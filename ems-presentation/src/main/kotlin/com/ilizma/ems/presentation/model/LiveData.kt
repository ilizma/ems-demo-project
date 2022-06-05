package com.ilizma.ems.presentation.model

data class LiveData(
    val buildingDemand: Double,
    val currentEnergy: Double,
    val gridPower: Double,
    val quasarsPower: Double,
    val solarPower: Double,
    val systemSoc: Double,
    val totalEnergy: Int,
)