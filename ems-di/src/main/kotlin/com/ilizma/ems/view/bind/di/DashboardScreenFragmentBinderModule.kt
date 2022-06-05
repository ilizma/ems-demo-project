package com.ilizma.ems.view.bind.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ilizma.ems.presentation.viewmodel.factory.di.DASHBOARD_SCREEN_VIEW_MODEL_PROVIDER_NAMED
import com.ilizma.ems.view.bind.DashboardScreenFragmentBinder
import com.ilizma.ems.view.bind.DashboardScreenFragmentBinderImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named

@Module
@InstallIn(FragmentComponent::class)
object DashboardScreenFragmentBinderModule {

    @Provides
    fun provideDashboardScreenFragmentBinder(
        fragment: Fragment,
        @Named(DASHBOARD_SCREEN_VIEW_MODEL_PROVIDER_NAMED) viewModelProviderFactory: ViewModelProvider.Factory,
    ): DashboardScreenFragmentBinder = DashboardScreenFragmentBinderImp(
        viewModelLazy = fragment.viewModels { viewModelProviderFactory },
        lifecycleOwner = { fragment.viewLifecycleOwner },
    )

}