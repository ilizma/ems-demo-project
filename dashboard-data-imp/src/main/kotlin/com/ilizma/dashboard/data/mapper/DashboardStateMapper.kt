package com.ilizma.dashboard.data.mapper

import com.ilizma.dashboard.domain.model.DashboardState
import com.ilizma.api.model.HistoricData as ApiHistoricData
import com.ilizma.dashboard.data.model.DashboardState as DataDashboardState

class DashboardStateMapper(
    private val mapper: HistoricDataMapper,
) {

    fun from(
        data: List<ApiHistoricData>,
    ): DataDashboardState = DataDashboardState.Success(
        data.mapIndexed { index, historicData -> mapper.from(index.toString(), historicData) }
    )

    fun from(
        state: DataDashboardState,
    ): DashboardState = when (state) {
        is DataDashboardState.Error -> DashboardState.Error(state.message)
        is DataDashboardState.Success -> state.historicData
            .map { mapper.from(it) }
            .let { DashboardState.Success(it) }
    }

}