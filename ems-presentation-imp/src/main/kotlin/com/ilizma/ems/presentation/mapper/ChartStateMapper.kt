package com.ilizma.ems.presentation.mapper

import com.ilizma.ems.domain.model.ChartState
import com.ilizma.ems.presentation.model.ChartState as PresentationChartState

class ChartStateMapper(
    private val mapper: HistoricDataMapper,
) {

    fun from(
        state: ChartState,
    ): PresentationChartState.Success = (state as ChartState.Success).data
        .map { mapper.from(it) }
        .let { PresentationChartState.Success(it) }

}