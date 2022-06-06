package com.ilizma.ems.domain.model

data class HistoricData(
    val buildingActive: List<Double>,
    val gridActive: List<Double>,
    val pvActive: List<Double>,
    val quasarsActive: List<Double>,
    val dateList: List<String>,
)