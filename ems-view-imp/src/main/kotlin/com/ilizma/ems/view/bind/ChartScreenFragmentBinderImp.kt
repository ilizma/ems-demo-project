package com.ilizma.ems.view.bind

import androidx.lifecycle.LifecycleOwner
import com.ilizma.ems.presentation.model.ChartState
import com.ilizma.ems.presentation.viewmodel.ChartScreenViewModel
import com.ilizma.ems.view.databinding.ChartScreenFragmentBinding

class ChartScreenFragmentBinderImp(
    viewModelLazy: Lazy<ChartScreenViewModel>,
    private val lifecycleOwner: () -> LifecycleOwner,
) : ChartScreenFragmentBinder {

    private val viewModel by viewModelLazy
    private lateinit var binding: ChartScreenFragmentBinding

    override fun bind(binding: ChartScreenFragmentBinding) {
        this.binding = binding
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.chart.observe(
            lifecycleOwner(),
        ) { onChartState(it) }
    }

    private fun onChartState(
        success: ChartState.Success,
    ) {
        // TODO: set data
    }

}