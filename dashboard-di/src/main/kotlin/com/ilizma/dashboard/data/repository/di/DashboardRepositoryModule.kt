package com.ilizma.dashboard.data.repository.di

import com.ilizma.dashboard.data.cache.DashboardCache
import com.ilizma.dashboard.data.datasource.DashboardDataSource
import com.ilizma.dashboard.data.mapper.DashboardStateMapper
import com.ilizma.dashboard.data.mapper.HistoricDataMapper
import com.ilizma.dashboard.data.repository.DashboardRepositoryImp
import com.ilizma.dashboard.domain.repository.DashboardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object DashboardRepositoryModule {

    @Provides
    fun provideDashboardRepository(
        dataSource: DashboardDataSource,
        cache: DashboardCache,
    ): DashboardRepository = DashboardRepositoryImp(
        dataSource = dataSource,
        cache = cache,
        mapper = DashboardStateMapper(HistoricDataMapper()),
    )

}