package com.ilizma.dashboard.presentation.mapper

import com.ilizma.dashboard.domain.model.HistoricData
import com.ilizma.dashboard.presentation.model.HistoricData as PresentationHistoricData

class HistoricDataMapper {

    fun from(
        data: HistoricData,
    ): PresentationHistoricData = PresentationHistoricData(
        buildingActivePower = data.buildingActivePower,
        gridActivePower = data.gridActivePower,
        pvActivePower = data.pvActivePower,
        quasarsActivePower = data.quasarsActivePower,
        timestamp = data.timestamp
    )
    
}