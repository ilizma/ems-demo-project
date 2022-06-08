package com.ilizma.ems.data.datasource.di

import android.content.Context
import com.ilizma.api.data.EnergySourcesApi
import com.ilizma.ems.data.datasource.EmsDataSource
import com.ilizma.ems.data.datasource.EmsDataSourceImp
import com.ilizma.ems.data.mapper.ChartStateMapper
import com.ilizma.ems.data.mapper.DashboardStateMapper
import com.ilizma.ems.data.mapper.HistoricDataMapper
import com.ilizma.resources.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(FragmentComponent::class)
object DashboardDataSourceModule {

    @Provides
    fun provideDashboardDataSource(
        @ApplicationContext context: Context,
        api: EnergySourcesApi,
    ): EmsDataSource = EmsDataSourceImp(
        api = api,
        dashboardMapper = DashboardStateMapper(),
        chartMapper = ChartStateMapper(HistoricDataMapper()),
        unknownError = context.getString(R.string.unknown_error)
    )

}