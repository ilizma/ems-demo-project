package com.ilizma.ems.view.viewholder.factory.di

import com.ilizma.ems.view.viewholder.factory.WidgetViewHolderFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object WidgetViewHolderFactoryModule {

    @Provides
    fun provideWidgetViewHolder(
    ): WidgetViewHolderFactory = WidgetViewHolderFactory()

}