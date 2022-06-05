package com.ilizma.ems.view.router.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ilizma.ems.flow.navigator.ChartScreenBackCloseNavigator
import com.ilizma.ems.flow.router.ChartScreenRouterImp
import com.ilizma.ems.presentation.viewmodel.factory.di.CHART_SCREEN_VIEW_MODEL_PROVIDER_NAMED
import com.ilizma.ems.view.router.ChartScreenRouter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named

@Module
@InstallIn(FragmentComponent::class)
object ChartScreenRouterModule {

    @Provides
    fun provideChartScreenRouter(
        fragment: Fragment,
        navigator: ChartScreenBackCloseNavigator,
        @Named(CHART_SCREEN_VIEW_MODEL_PROVIDER_NAMED) viewModelProviderFactory: ViewModelProvider.Factory,
    ): ChartScreenRouter = ChartScreenRouterImp(
        lifecycleOwner = { fragment.viewLifecycleOwner },
        onBackPressedDispatcher = fragment.requireActivity().onBackPressedDispatcher,
        viewModelLazy = fragment.viewModels { viewModelProviderFactory },
        navigator = navigator,
    )

}