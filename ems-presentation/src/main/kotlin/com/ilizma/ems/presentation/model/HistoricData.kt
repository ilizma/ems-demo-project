package com.ilizma.ems.presentation.model

data class HistoricData(
    val buildingActive: List<Double>,
    val gridActive: List<Double>,
    val pvActive: List<Double>,
    val quasarsActive: List<Double>,
    val dateList: List<String>,
)