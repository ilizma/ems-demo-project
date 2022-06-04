package com.ilizma.dashboard.presentation.model

sealed class DashboardState {

    data class Success(
        val historicData: List<HistoricData>
    ) : DashboardState()

    data class Error(val message: String) : DashboardState()

}