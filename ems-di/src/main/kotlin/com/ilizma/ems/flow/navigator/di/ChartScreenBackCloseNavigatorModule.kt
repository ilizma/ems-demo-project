package com.ilizma.ems.flow.navigator.di

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ilizma.ems.flow.navigator.ChartScreenBackCloseNavigator
import com.ilizma.ems.flow.navigator.ChartScreenBackCloseNavigatorImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object ChartScreenBackCloseNavigatorModule {

    @Provides
    fun provideChartScreenBackCloseNavigator(
        fragment: Fragment,
    ): ChartScreenBackCloseNavigator = ChartScreenBackCloseNavigatorImp(
        navController = fragment.findNavController(),
    )

}