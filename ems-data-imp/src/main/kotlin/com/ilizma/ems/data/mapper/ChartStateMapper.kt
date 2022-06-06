package com.ilizma.ems.data.mapper

import com.ilizma.ems.domain.model.ChartState
import com.ilizma.api.model.HistoricData as ApiHistoricData
import com.ilizma.ems.data.model.ChartState as DataChartState

class ChartStateMapper(
    private val mapper: HistoricDataMapper,
) {

    fun from(
        data: List<ApiHistoricData>,
    ): DataChartState = DataChartState.Success(
        mapper.from(data)
    )

    fun from(
        state: DataChartState,
    ): ChartState = when (state) {
        is DataChartState.Error -> ChartState.Error(state.message)
        is DataChartState.Success -> state.data
            .let { mapper.from(it) }
            .let { ChartState.Success(it) }
    }

}