package com.ilizma.dashboard.view.adapter.util.di

import com.ilizma.dashboard.view.adapter.util.WidgetDiffUtil
import com.ilizma.dashboard.view.adapter.util.WidgetDiffUtilImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object WidgetDiffUtilModule {

    @Provides
    fun provideWidgetDiffUtil(
    ): WidgetDiffUtil = WidgetDiffUtilImp()

}