package com.ilizma.ems.presentation.mapper

import com.ilizma.ems.domain.model.DashboardState
import com.ilizma.ems.presentation.model.DashboardState as PresentationDashboardState

class DashboardStateMapper(
    private val mapper: HistoricDataMapper,
) {

    fun from(
        state: DashboardState,
    ): PresentationDashboardState.Success = (state as DashboardState.Success).historicData
        .map { mapper.from(it) }
        .let { PresentationDashboardState.Success(it) }

}