package com.ilizma.ems.data.repository.di

import com.ilizma.ems.data.cache.ChartCache
import com.ilizma.ems.data.cache.DashboardCache
import com.ilizma.ems.data.datasource.EmsDataSource
import com.ilizma.ems.data.mapper.ChartStateMapper
import com.ilizma.ems.data.mapper.DashboardStateMapper
import com.ilizma.ems.data.mapper.HistoricDataMapper
import com.ilizma.ems.data.repository.EmsRepositoryImp
import com.ilizma.ems.domain.repository.EmsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object DashboardRepositoryModule {

    @Provides
    fun provideDashboardRepository(
        dataSource: EmsDataSource,
        dashboardCache: DashboardCache,
        chartCache: ChartCache,
    ): EmsRepository = EmsRepositoryImp(
        dataSource = dataSource,
        dashboardCache = dashboardCache,
        chartCache = chartCache,
        dashboardStateMapper = DashboardStateMapper(),
        chartStateMapper = ChartStateMapper(HistoricDataMapper()),
    )

}