package com.ilizma.dashboard.view.bind.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ilizma.dashboard.presentation.viewmodel.factory.di.DASHBOARD_SCREEN_VIEW_MODEL_PROVIDER_NAMED
import com.ilizma.dashboard.view.bind.DashboardScreenFragmentBinder
import com.ilizma.dashboard.view.bind.DashboardScreenFragmentBinderImp
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
        //adapterFactory: DaysAdapterFactory,
        @Named(DASHBOARD_SCREEN_VIEW_MODEL_PROVIDER_NAMED) viewModelProviderFactory: ViewModelProvider.Factory,
    ): DashboardScreenFragmentBinder = DashboardScreenFragmentBinderImp(
        viewModelLazy = fragment.viewModels { viewModelProviderFactory },
        lifecycleOwner = { fragment.viewLifecycleOwner },
        //adapterFactory = adapterFactory,
    )

}