package com.ilizma.dashboard.data.mapper

import com.ilizma.dashboard.domain.model.HistoricData
import com.ilizma.dashboard.data.model.HistoricData as DataHistoricData
import com.ilizma.api.model.HistoricData as ApiHistoricData

class HistoricDataMapper {

    fun from(
        data: ApiHistoricData,
    ): DataHistoricData = DataHistoricData(
        buildingActivePower = data.buildingActivePower,
        gridActivePower = data.gridActivePower,
        pvActivePower = data.pvActivePower,
        quasarsActivePower = data.quasarsActivePower,
        timestamp = data.timestamp
    )

    fun from(
        data: DataHistoricData,
    ): HistoricData = HistoricData(
        buildingActivePower = data.buildingActivePower,
        gridActivePower = data.gridActivePower,
        pvActivePower = data.pvActivePower,
        quasarsActivePower = data.quasarsActivePower,
        timestamp = data.timestamp
    )

}