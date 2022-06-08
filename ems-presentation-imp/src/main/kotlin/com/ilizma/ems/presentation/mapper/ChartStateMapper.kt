package com.ilizma.ems.presentation.mapper

import com.ilizma.ems.domain.model.ChartState
import com.ilizma.ems.presentation.model.ChartState as PresentationChartState

class ChartStateMapper(
    private val mapper: HistoricDataMapper,
) {

    fun from(
        state: ChartState,
    ): PresentationChartState = when (state) {
        is ChartState.Error -> PresentationChartState.Error(state.message)
        is ChartState.Success -> state.data
            .let { mapper.from(it) }
            .let { PresentationChartState.Success(it) }
    }

}