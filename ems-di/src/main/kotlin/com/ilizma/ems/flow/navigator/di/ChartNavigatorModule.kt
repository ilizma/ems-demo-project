package com.ilizma.ems.flow.navigator.di

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ilizma.ems.flow.navigator.ChartNavigator
import com.ilizma.ems.flow.navigator.ChartNavigatorImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object ChartNavigatorModule {

    @Provides
    fun provideChartNavigator(
        fragment: Fragment,
    ): ChartNavigator = ChartNavigatorImp(
        navController = fragment.findNavController(),
    )

}