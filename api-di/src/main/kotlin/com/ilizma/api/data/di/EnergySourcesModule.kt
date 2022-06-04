package com.ilizma.api.data.di

import android.content.Context
import com.ilizma.api.data.EnergySourcesApi
import com.ilizma.api.data.EnergySourcesApiImp
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(FragmentComponent::class)
object EnergySourcesModule {

    @Provides
    fun provideEnergySources(
        @ApplicationContext context: Context,
        moshi: Moshi,
    ): EnergySourcesApi = EnergySourcesApiImp(
        context,
        moshi,
    )

}