package com.ilizma.dashboard.data.datasource.di

import com.ilizma.api.data.EnergySourcesApi
import com.ilizma.dashboard.data.datasource.DashboardDataSource
import com.ilizma.dashboard.data.datasource.DashboardDataSourceImp
import com.ilizma.dashboard.data.mapper.DashboardStateMapper
import com.ilizma.dashboard.data.mapper.HistoricDataMapper
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
    ): DashboardDataSource = DashboardDataSourceImp(
        api = api,
        mapper = DashboardStateMapper(HistoricDataMapper()),
    )

}