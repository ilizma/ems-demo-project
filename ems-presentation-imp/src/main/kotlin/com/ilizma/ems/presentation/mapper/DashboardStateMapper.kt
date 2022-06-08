package com.ilizma.ems.presentation.mapper

import com.ilizma.ems.domain.model.DashboardState
import com.ilizma.ems.domain.model.LiveData
import com.ilizma.ems.presentation.model.DashboardState as PresentationDashboardState
import com.ilizma.ems.presentation.model.LiveData as PresentationLiveData

class DashboardStateMapper {

    fun from(
        state: DashboardState,
    ): PresentationDashboardState = when (state) {
        is DashboardState.Error -> PresentationDashboardState.Error(state.message)
        is DashboardState.Success -> state.data
            .let { generateLiveData(it) }
            .let { PresentationDashboardState.Success(it) }
    }

    private fun generateLiveData(
        data: LiveData,
    ): PresentationLiveData = PresentationLiveData(
        buildingDemand = data.buildingDemand,
        currentEnergy = data.currentEnergy,
        gridPower = data.gridPower,
        quasarsPower = data.quasarsPower,
        solarPower = data.solarPower,
        systemSoc = data.systemSoc,
        totalEnergy = data.totalEnergy,
    )

}