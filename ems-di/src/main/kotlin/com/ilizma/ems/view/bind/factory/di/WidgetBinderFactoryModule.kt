package com.ilizma.ems.view.bind.factory.di

import com.ilizma.ems.view.bind.factory.WidgetBinderFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object WidgetBinderFactoryModule {

    @Provides
    fun provideWidgetBinderFactory(
    ): WidgetBinderFactory = WidgetBinderFactory()

}