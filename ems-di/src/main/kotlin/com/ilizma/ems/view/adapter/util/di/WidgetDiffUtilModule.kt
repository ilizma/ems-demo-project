package com.ilizma.ems.view.adapter.util.di

import com.ilizma.ems.view.adapter.util.WidgetDiffUtil
import com.ilizma.ems.view.adapter.util.WidgetDiffUtilImp
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