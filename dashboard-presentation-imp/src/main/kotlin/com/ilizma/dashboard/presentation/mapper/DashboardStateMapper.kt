package com.ilizma.dashboard.presentation.mapper

import com.ilizma.dashboard.domain.model.DashboardState
import com.ilizma.dashboard.presentation.model.DashboardState as PresentationDashboardState

class DashboardStateMapper(
    private val mapper: HistoricDataMapper,
) {

    fun from(
        state: DashboardState,
    ): PresentationDashboardState.Success = (state as DashboardState.Success).historicData
        .map { mapper.from(it) }
        .let { PresentationDashboardState.Success(it) }

}