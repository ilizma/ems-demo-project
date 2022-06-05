package com.ilizma.ems.data.cache.di

import com.ilizma.ems.data.cache.DashboardCache
import com.ilizma.ems.data.cache.DashboardCacheImp
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