package com.ilizma.ems.presentation.viewmodel.factory.di

import androidx.lifecycle.ViewModelProvider
import com.ilizma.ems.presentation.viewmodel.factory.DashboardScreenViewModelAssistedFactory
import com.ilizma.ems.presentation.viewmodel.factory.DashboardScreenViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named

const val DASHBOARD_SCREEN_VIEW_MODEL_PROVIDER_NAMED = "DASHBOARD_SCREEN_VIEW_MODEL_PROVIDER_NAMED"

@Module
@InstallIn(FragmentComponent::class)
object DashboardScreenViewModelFactoryModule {

    @Provides
    @Named(DASHBOARD_SCREEN_VIEW_MODEL_PROVIDER_NAMED)
    fun provideDashboardScreenViewModelFactory(
        radioScreenViewModelAssistedFactory: DashboardScreenViewModelAssistedFactory,
    ): ViewModelProvider.Factory = DashboardScreenViewModelFactory(
        radioScreenViewModelAssistedFactory,
    )

}