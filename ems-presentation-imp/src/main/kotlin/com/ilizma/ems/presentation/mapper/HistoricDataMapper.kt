package com.ilizma.ems.presentation.mapper

import com.ilizma.ems.domain.model.HistoricData
import com.ilizma.ems.presentation.model.HistoricData as PresentationHistoricData

class HistoricDataMapper {

    fun from(
        data: HistoricData,
    ): PresentationHistoricData = PresentationHistoricData(
        id = data.id,
        buildingActivePower = data.buildingActivePower,
        gridActivePower = data.gridActivePower,
        pvActivePower = data.pvActivePower,
        quasarsActivePower = data.quasarsActivePower,
        date = data.date
    )
    
}