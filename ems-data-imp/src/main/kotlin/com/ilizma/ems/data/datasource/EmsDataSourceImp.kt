package com.ilizma.ems.data.datasource

import com.ilizma.api.data.EnergySourcesApi
import com.ilizma.ems.data.mapper.DashboardStateMapper
import com.ilizma.ems.data.model.DashboardState
import io.reactivex.rxjava3.core.Single

class EmsDataSourceImp(
    private val api: EnergySourcesApi,
    private val mapper: DashboardStateMapper,
) : EmsDataSource {

    override fun get(
    ): Single<DashboardState> = api.getHistoricDataList()
        .map { mapper.from(it) }

}