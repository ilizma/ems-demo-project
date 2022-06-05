package com.ilizma.ems.data.repository

import com.ilizma.ems.data.cache.DashboardCache
import com.ilizma.ems.data.datasource.EmsDataSource
import com.ilizma.ems.data.mapper.DashboardStateMapper
import com.ilizma.ems.domain.model.DashboardState
import com.ilizma.ems.domain.repository.EmsRepository
import io.reactivex.rxjava3.core.Single
import com.ilizma.ems.data.model.DashboardState as DataDashboardState

class EmsRepositoryImp(
    private val dataSource: EmsDataSource,
    private val cache: DashboardCache,
    private val mapper: DashboardStateMapper,
) : EmsRepository {

    override fun get(
    ): Single<DashboardState> = (getFromCacheIfExist() ?: getFromApiAndSaveCache())
        .map { mapper.from(it) }

    private fun getFromCacheIfExist(
    ): Single<DataDashboardState>? = cache.cache
        ?.let { Single.just(it) }

    private fun getFromApiAndSaveCache(
    ): Single<DataDashboardState> = dataSource.get()
        .doOnSuccess { cache.cache = it }

}