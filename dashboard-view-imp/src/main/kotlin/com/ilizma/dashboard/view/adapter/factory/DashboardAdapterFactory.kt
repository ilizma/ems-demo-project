package com.ilizma.dashboard.view.adapter.factory

import com.ilizma.dashboard.presentation.viewmodel.DashboardScreenViewModel
import com.ilizma.dashboard.view.adapter.DashboardAdapter
import com.ilizma.dashboard.view.adapter.DashboardAdapterImp
import com.ilizma.dashboard.view.adapter.util.WidgetDiffUtil
import com.ilizma.dashboard.view.bind.factory.WidgetBinderFactory
import com.ilizma.dashboard.view.viewholder.factory.WidgetViewHolderFactory

class DashboardAdapterFactory(
    private val binderFactory: WidgetBinderFactory,
    private val diffUtil: WidgetDiffUtil,
    private val viewHolderFactory: WidgetViewHolderFactory,
    private val viewModelLazy: Lazy<DashboardScreenViewModel>,
) {

    fun create(
    ): DashboardAdapter = DashboardAdapterImp(
            binderFactory = binderFactory,
            diffUtil = diffUtil,
            viewHolderFactory = viewHolderFactory,
            viewModel = viewModelLazy.value,
    )

}