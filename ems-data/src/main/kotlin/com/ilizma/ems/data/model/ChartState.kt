package com.ilizma.ems.data.model

sealed class ChartState {

    data class Success(
        val data: HistoricData
    ) : ChartState()

    data class Error(val message: String) : ChartState()

}