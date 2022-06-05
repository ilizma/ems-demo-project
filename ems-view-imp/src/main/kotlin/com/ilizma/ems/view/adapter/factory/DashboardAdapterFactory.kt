package com.ilizma.ems.view.adapter.factory

import com.ilizma.ems.presentation.viewmodel.DashboardScreenViewModel
import com.ilizma.ems.view.adapter.DashboardAdapter
import com.ilizma.ems.view.adapter.DashboardAdapterImp
import com.ilizma.ems.view.adapter.util.WidgetDiffUtil
import com.ilizma.ems.view.bind.factory.WidgetBinderFactory
import com.ilizma.ems.view.viewholder.factory.WidgetViewHolderFactory

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