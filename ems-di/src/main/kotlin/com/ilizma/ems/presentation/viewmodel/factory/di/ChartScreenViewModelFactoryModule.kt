package com.ilizma.ems.presentation.viewmodel.factory.di

import androidx.lifecycle.ViewModelProvider
import com.ilizma.ems.presentation.viewmodel.factory.ChartScreenViewModelAssistedFactory
import com.ilizma.ems.presentation.viewmodel.factory.ChartScreenViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named

const val CHART_SCREEN_VIEW_MODEL_PROVIDER_NAMED = "CHART_SCREEN_VIEW_MODEL_PROVIDER_NAMED"

@Module
@InstallIn(FragmentComponent::class)
object ChartScreenViewModelFactoryModule {

    @Provides
    @Named(CHART_SCREEN_VIEW_MODEL_PROVIDER_NAMED)
    fun provideChartScreenViewModelFactory(
        radioScreenViewModelAssistedFactory: ChartScreenViewModelAssistedFactory,
    ): ViewModelProvider.Factory = ChartScreenViewModelFactory(
        radioScreenViewModelAssistedFactory,
    )

}