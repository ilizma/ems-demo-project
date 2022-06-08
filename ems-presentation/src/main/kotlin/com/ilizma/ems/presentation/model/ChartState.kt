package com.ilizma.ems.presentation.model

sealed class ChartState {

    data class Success(
        val data: HistoricData
    ) : ChartState()

    data class Error(val message: String) : ChartState()

    object Loading : ChartState()

}