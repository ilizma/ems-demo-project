package com.ilizma.ems.data.repository

import com.ilizma.ems.data.cache.ChartCache
import com.ilizma.ems.data.cache.DashboardCache
import com.ilizma.ems.data.datasource.EmsDataSource
import com.ilizma.ems.data.mapper.ChartStateMapper
import com.ilizma.ems.data.mapper.DashboardStateMapper
import com.ilizma.ems.domain.model.ChartState
import com.ilizma.ems.domain.model.DashboardState
import com.ilizma.ems.domain.repository.EmsRepository
import io.reactivex.rxjava3.core.Single
import com.ilizma.ems.data.model.ChartState as DataChartState
import com.ilizma.ems.data.model.DashboardState as DataDashboardState

class EmsRepositoryImp(
    private val dataSource: EmsDataSource,
    private val dashboardCache: DashboardCache,
    private val chartCache: ChartCache,
    private val dashboardStateMapper: DashboardStateMapper,
    private val chartStateMapper: ChartStateMapper,
) : EmsRepository {

    override fun getDashboardState(
    ): Single<DashboardState> =
        (getDashboardStateFromCache() ?: getDashboardStateFromApiAndSaveCache())
            .map { dashboardStateMapper.from(it) }

    override fun getChartState(
    ): Single<ChartState> = (getChartStateFromCache() ?: getChartStateFromApiAndSaveCache())
        .map { chartStateMapper.from(it) }

    private fun getDashboardStateFromCache(
    ): Single<DataDashboardState>? = dashboardCache.cache
        ?.let { Single.just(it) }

    private fun getDashboardStateFromApiAndSaveCache(
    ): Single<DataDashboardState> = dataSource.getDashboardState()
        .doOnSuccess { if (it is DataDashboardState.Success) dashboardCache.cache = it }

    private fun getChartStateFromCache(
    ): Single<DataChartState>? = chartCache.cache
        ?.let { Single.just(it) }

    private fun getChartStateFromApiAndSaveCache(
    ): Single<DataChartState> = dataSource.getChartState()
        .doOnSuccess { if (it is DataChartState.Success) chartCache.cache = it }

}