package com.ilizma.ems.data.datasource

import com.ilizma.api.data.EnergySourcesApi
import com.ilizma.ems.data.mapper.ChartStateMapper
import com.ilizma.ems.data.mapper.DashboardStateMapper
import com.ilizma.ems.data.model.ChartState
import com.ilizma.ems.data.model.DashboardState
import io.reactivex.rxjava3.core.Single

class EmsDataSourceImp(
    private val api: EnergySourcesApi,
    private val dashboardMapper: DashboardStateMapper,
    private val chartMapper: ChartStateMapper,
) : EmsDataSource {

    override fun getDashboardState(
    ): Single<DashboardState> = api.getLiveData()
        .map { dashboardMapper.from(it) }

    override fun getChartState(
    ): Single<ChartState> = api.getHistoricDataList()
        .map { chartMapper.from(it) }

}