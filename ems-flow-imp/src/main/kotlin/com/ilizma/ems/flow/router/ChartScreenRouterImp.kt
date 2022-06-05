package com.ilizma.ems.flow.router

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.lifecycle.LifecycleOwner
import com.ilizma.ems.flow.navigator.ChartScreenBackCloseNavigator
import com.ilizma.ems.presentation.model.ChartScreenNavigationAction
import com.ilizma.ems.presentation.model.ChartScreenNavigationAction.Back
import com.ilizma.ems.presentation.viewmodel.ChartScreenViewModel
import com.ilizma.ems.view.router.ChartScreenRouter

class ChartScreenRouterImp(
    private val lifecycleOwner: () -> LifecycleOwner,
    private val onBackPressedDispatcher: OnBackPressedDispatcher,
    viewModelLazy: Lazy<ChartScreenViewModel>,
    private val navigator: ChartScreenBackCloseNavigator,
) : ChartScreenRouter {

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
        action: ChartScreenNavigationAction,
    ) {
        when (action) {
            Back -> navigator.close()
        }
    }

}