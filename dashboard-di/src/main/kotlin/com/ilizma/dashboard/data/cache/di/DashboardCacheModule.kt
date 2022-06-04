package com.ilizma.dashboard.data.cache.di

import com.ilizma.dashboard.data.cache.DashboardCache
import com.ilizma.dashboard.data.cache.DashboardCacheImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object DashboardCacheModule {

    @Provides
    fun provideDashboardCache(
    ): DashboardCache = DashboardCacheImp()

}