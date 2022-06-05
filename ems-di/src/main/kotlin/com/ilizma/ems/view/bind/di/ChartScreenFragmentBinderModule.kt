package com.ilizma.ems.view.bind.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ilizma.ems.presentation.viewmodel.factory.di.CHART_SCREEN_VIEW_MODEL_PROVIDER_NAMED
import com.ilizma.ems.view.bind.ChartScreenFragmentBinder
import com.ilizma.ems.view.bind.ChartScreenFragmentBinderImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named

@Module
@InstallIn(FragmentComponent::class)
object ChartScreenFragmentBinderModule {

    @Provides
    fun provideChartScreenFragmentBinder(
        fragment: Fragment,
        @Named(CHART_SCREEN_VIEW_MODEL_PROVIDER_NAMED) viewModelProviderFactory: ViewModelProvider.Factory,
    ): ChartScreenFragmentBinder = ChartScreenFragmentBinderImp(
        viewModelLazy = fragment.viewModels { viewModelProviderFactory },
        lifecycleOwner = { fragment.viewLifecycleOwner },
    )

}