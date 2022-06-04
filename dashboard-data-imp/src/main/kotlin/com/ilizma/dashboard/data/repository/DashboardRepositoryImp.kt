package com.ilizma.dashboard.data.repository

import com.ilizma.dashboard.data.cache.DashboardCache
import com.ilizma.dashboard.data.datasource.DashboardDataSource
import com.ilizma.dashboard.data.mapper.DashboardStateMapper
import com.ilizma.dashboard.domain.model.DashboardState
import com.ilizma.dashboard.domain.repository.DashboardRepository
import io.reactivex.rxjava3.core.Single
import com.ilizma.dashboard.data.model.DashboardState as DataScheduleState

class DashboardRepositoryImp(
    private val dataSource: DashboardDataSource,
    private val cache: DashboardCache,
    private val mapper: DashboardStateMapper,
) : DashboardRepository {

    override fun get(): Single<DashboardState> = (getFromCacheIfExist() ?: getFromApiAndSaveCache())
        .map { mapper.from(it) }

    private fun getFromCacheIfExist(
    ): Single<DataScheduleState>? = cache.cache
        ?.let { Single.just(it) }

    private fun getFromApiAndSaveCache(
    ): Single<DataScheduleState> = dataSource.get()
        .doOnSuccess { cache.cache = it }

}