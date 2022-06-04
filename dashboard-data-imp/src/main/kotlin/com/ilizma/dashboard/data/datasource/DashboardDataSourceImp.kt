package com.ilizma.dashboard.data.datasource

import com.ilizma.api.data.EnergySourcesApi
import com.ilizma.dashboard.data.mapper.DashboardStateMapper
import com.ilizma.dashboard.data.model.DashboardState
import io.reactivex.rxjava3.core.Single

class DashboardDataSourceImp(
    private val api: EnergySourcesApi,
    private val mapper: DashboardStateMapper,
) : DashboardDataSource {

    override fun get(
    ): Single<DashboardState> = api.getHistoricDataList()
        .map { mapper.from(it) }

}