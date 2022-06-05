package com.ilizma.ems.flow.navigator.di

import android.app.Activity
import com.ilizma.ems.flow.navigator.DashboardScreenBackCloseNavigator
import com.ilizma.ems.flow.navigator.DashboardScreenBackCloseNavigatorImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object DashboardScreenBackCloseNavigatorModule {

    @Provides
    fun provideDashboardScreenBackCloseNavigator(
        activity: Activity,
    ): DashboardScreenBackCloseNavigator = DashboardScreenBackCloseNavigatorImp(
        activity = activity,
    )

}