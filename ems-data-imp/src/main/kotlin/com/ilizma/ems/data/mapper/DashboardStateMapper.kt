package com.ilizma.ems.data.mapper

import com.ilizma.ems.domain.model.DashboardState
import com.ilizma.ems.domain.model.LiveData
import com.ilizma.api.model.LiveData as ApiLiveData
import com.ilizma.ems.data.model.DashboardState as DataDashboardState
import com.ilizma.ems.data.model.LiveData as DataLiveData

class DashboardStateMapper {

    fun from(
        data: ApiLiveData,
    ): DataDashboardState = DataLiveData(
        buildingDemand = data.buildingDemand,
        currentEnergy = data.currentEnergy,
        gridPower = data.gridPower,
        quasarsPower = data.quasarsPower,
        solarPower = data.solarPower,
        systemSoc = data.systemSoc,
        totalEnergy = data.totalEnergy,
    ).let { DataDashboardState.Success(it) }

    fun from(
        state: DataDashboardState,
    ): DashboardState = when (state) {
        is DataDashboardState.Error -> DashboardState.Error(state.message)
        is DataDashboardState.Success -> state.data
            .let { generateLiveData(it) }
            .let { DashboardState.Success(it) }
    }

    private fun generateLiveData(
        data: DataLiveData
    ): LiveData = LiveData(
        buildingDemand = data.buildingDemand,
        currentEnergy = data.currentEnergy,
        gridPower = data.gridPower,
        quasarsPower = data.quasarsPower,
        solarPower = data.solarPower,
        systemSoc = data.systemSoc,
        totalEnergy = data.totalEnergy,
    )

}