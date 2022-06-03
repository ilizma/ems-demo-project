package com.ilizma.dashboard.view.bind.di

import com.ilizma.dashboard.view.bind.DashboardScreenFragmentBinder
import com.ilizma.dashboard.view.bind.DashboardScreenFragmentBinderImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object DashboardScreenFragmentBinderModule {

    @Provides
    fun provideMenuScreenFragmentBinder(

    ): DashboardScreenFragmentBinder = DashboardScreenFragmentBinderImp(

    )

}