package com.ilizma.ems.domain.model

sealed class ChartState {

    data class Success(
        val data: HistoricData
    ) : ChartState()

    data class Error(val message: String) : ChartState()

}