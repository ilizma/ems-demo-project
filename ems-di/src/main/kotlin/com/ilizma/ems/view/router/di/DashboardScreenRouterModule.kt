package com.ilizma.ems.view.router.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ilizma.ems.flow.navigator.ChartNavigator
import com.ilizma.ems.flow.navigator.DashboardScreenBackCloseNavigator
import com.ilizma.ems.flow.router.DashboardScreenRouterImp
import com.ilizma.ems.presentation.viewmodel.factory.di.DASHBOARD_SCREEN_VIEW_MODEL_PROVIDER_NAMED
import com.ilizma.ems.view.router.DashboardScreenRouter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named

@Module
@InstallIn(FragmentComponent::class)
object DashboardScreenRouterModule {

    @Provides
    fun provideDashboardScreenRouter(
        fragment: Fragment,
        backCloseNavigator: DashboardScreenBackCloseNavigator,
        chartNavigator: ChartNavigator,
        @Named(DASHBOARD_SCREEN_VIEW_MODEL_PROVIDER_NAMED) viewModelProviderFactory: ViewModelProvider.Factory,
    ): DashboardScreenRouter = DashboardScreenRouterImp(
        lifecycleOwner = { fragment.viewLifecycleOwner },
        onBackPressedDispatcher = fragment.requireActivity().onBackPressedDispatcher,
        viewModelLazy = fragment.viewModels { viewModelProviderFactory },
        backCloseNavigator = backCloseNavigator,
        chartNavigator = chartNavigator,
    )

}