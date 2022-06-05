package com.ilizma.ems.view.adapter.facory.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ilizma.ems.presentation.viewmodel.factory.di.DASHBOARD_SCREEN_VIEW_MODEL_PROVIDER_NAMED
import com.ilizma.ems.view.adapter.factory.DashboardAdapterFactory
import com.ilizma.ems.view.adapter.util.WidgetDiffUtil
import com.ilizma.ems.view.bind.factory.WidgetBinderFactory
import com.ilizma.ems.view.viewholder.factory.WidgetViewHolderFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named

@Module
@InstallIn(FragmentComponent::class)
object DashboardAdapterFactoryModule {

    @Provides
    fun provideDashboardAdapterFactory(
        fragment: Fragment,
        binderFactory: WidgetBinderFactory,
        diffUtil: WidgetDiffUtil,
        viewHolderFactory: WidgetViewHolderFactory,
        @Named(DASHBOARD_SCREEN_VIEW_MODEL_PROVIDER_NAMED) viewModelProviderFactory: ViewModelProvider.Factory,
    ): DashboardAdapterFactory = DashboardAdapterFactory(
        binderFactory = binderFactory,
        diffUtil = diffUtil,
        viewHolderFactory = viewHolderFactory,
        viewModelLazy = fragment.viewModels { viewModelProviderFactory },
    )

}