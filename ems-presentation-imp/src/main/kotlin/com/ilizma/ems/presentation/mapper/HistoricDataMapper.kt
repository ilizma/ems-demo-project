package com.ilizma.ems.presentation.mapper

import com.ilizma.ems.domain.model.HistoricData
import com.ilizma.ems.presentation.model.HistoricData as PresentationHistoricData

class HistoricDataMapper {

    fun from(
        data: HistoricData,
    ): PresentationHistoricData = PresentationHistoricData(
        buildingActive = data.buildingActive,
        gridActive = data.gridActive,
        pvActive = data.pvActive,
        quasarsActive = data.quasarsActive,
        dateList = data.dateList,
    )

}