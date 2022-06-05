package com.ilizma.ems.data.datasource.di

import com.ilizma.api.data.EnergySourcesApi
import com.ilizma.ems.data.datasource.EmsDataSource
import com.ilizma.ems.data.datasource.EmsDataSourceImp
import com.ilizma.ems.data.mapper.ChartStateMapper
import com.ilizma.ems.data.mapper.DashboardStateMapper
import com.ilizma.ems.data.mapper.HistoricDataMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object DashboardDataSourceModule {

    @Provides
    fun provideDashboardDataSource(
        api: EnergySourcesApi,
    ): EmsDataSource = EmsDataSourceImp(
        api = api,
        dashboardMapper = DashboardStateMapper(),
        chartMapper = ChartStateMapper(HistoricDataMapper()),
    )

}