package com.ilizma.ems.data.mapper

import com.ilizma.ems.data.extension.getFormattedDate
import com.ilizma.ems.domain.model.HistoricData
import com.ilizma.api.model.HistoricData as ApiHistoricData
import com.ilizma.ems.data.model.HistoricData as DataHistoricData

class HistoricDataMapper {

    fun from(
        data: ApiHistoricData,
    ): DataHistoricData = DataHistoricData(
        buildingActivePower = data.buildingActivePower,
        gridActivePower = data.gridActivePower,
        pvActivePower = data.pvActivePower,
        quasarsActivePower = data.quasarsActivePower,
        date = data.timestamp.getFormattedDate()
    )

    fun from(
        data: DataHistoricData,
    ): HistoricData = HistoricData(
        buildingActivePower = data.buildingActivePower,
        gridActivePower = data.gridActivePower,
        pvActivePower = data.pvActivePower,
        quasarsActivePower = data.quasarsActivePower,
        date = data.date
    )

}