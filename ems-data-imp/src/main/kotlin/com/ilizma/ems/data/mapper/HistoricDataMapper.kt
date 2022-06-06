package com.ilizma.ems.data.mapper

import com.ilizma.ems.data.extension.getFormattedDate
import com.ilizma.ems.domain.model.HistoricData
import com.ilizma.api.model.HistoricData as ApiHistoricData
import com.ilizma.ems.data.model.HistoricData as DataHistoricData

class HistoricDataMapper {

    fun from(
        data: List<ApiHistoricData>,
    ): DataHistoricData {
        val buildingActiveList = mutableListOf<Double>()
        val gridActiveList = mutableListOf<Double>()
        val pvActiveList = mutableListOf<Double>()
        val quasarsActiveList = mutableListOf<Double>()
        val dateList = mutableListOf<String>()
        data.map {
            buildingActiveList.add(it.buildingActivePower)
            gridActiveList.add(it.gridActivePower)
            pvActiveList.add(it.pvActivePower)
            quasarsActiveList.add(it.quasarsActivePower)
            dateList.add(it.timestamp.getFormattedDate())
        }
        return DataHistoricData(
            buildingActive = buildingActiveList,
            gridActive = gridActiveList,
            pvActive = pvActiveList,
            quasarsActive = quasarsActiveList,
            dateList = dateList,
        )
    }

    fun from(
        data: DataHistoricData,
    ): HistoricData = HistoricData(
        buildingActive = data.buildingActive,
        gridActive = data.gridActive,
        pvActive = data.pvActive,
        quasarsActive = data.quasarsActive,
        dateList = data.dateList,
    )

}