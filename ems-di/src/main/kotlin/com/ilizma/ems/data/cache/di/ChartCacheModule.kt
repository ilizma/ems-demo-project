package com.ilizma.ems.data.cache.di

import com.ilizma.ems.data.cache.ChartCache
import com.ilizma.ems.data.cache.ChartCacheImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object ChartCacheModule {

    @Provides
    fun provideChartCache(
    ): ChartCache = ChartCacheImp()

}