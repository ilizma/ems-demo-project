package com.ilizma.ems.flow.router

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.lifecycle.LifecycleOwner
import com.ilizma.ems.flow.navigator.ChartNavigator
import com.ilizma.ems.flow.navigator.DashboardScreenBackCloseNavigator
import com.ilizma.ems.presentation.model.DashboardScreenNavigationAction
import com.ilizma.ems.presentation.viewmodel.DashboardScreenViewModel
import com.ilizma.ems.view.router.DashboardScreenRouter

class DashboardScreenRouterImp(
    private val lifecycleOwner: () -> LifecycleOwner,
    private val onBackPressedDispatcher: OnBackPressedDispatcher,
    viewModelLazy: Lazy<DashboardScreenViewModel>,
    private val dashboardScreenBackCloseNavigator: DashboardScreenBackCloseNavigator,
    private val chartNavigator: ChartNavigator,
) : DashboardScreenRouter {

    private val viewModel by viewModelLazy

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            viewModel.onBack()
        }
    }

    override fun init() {
        viewModel.navigationAction.observe(
            lifecycleOwner(),
        ) { onNavigationAction(it) }

        onBackPressedDispatcher.addCallback(lifecycleOwner(), onBackPressedCallback)
    }

    private fun onNavigationAction(
        action: DashboardScreenNavigationAction,
    ) {
        when (action) {
            DashboardScreenNavigationAction.Back -> dashboardScreenBackCloseNavigator.close()
            is DashboardScreenNavigationAction.Detail -> chartNavigator.navigate(action.id)
        }
    }

}