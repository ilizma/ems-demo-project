package com.ilizma.ems.view.bind

import androidx.lifecycle.LifecycleOwner
import com.ilizma.ems.presentation.model.ChartState
import com.ilizma.ems.presentation.viewmodel.ChartScreenViewModel
import com.ilizma.ems.view.databinding.ChartScreenFragmentBinding
import com.ilizma.resources.R

class ChartScreenFragmentBinderImp(
    viewModelLazy: Lazy<ChartScreenViewModel>,
    private val lifecycleOwner: () -> LifecycleOwner,
) : ChartScreenFragmentBinder {

    private val viewModel by viewModelLazy
    private lateinit var binding: ChartScreenFragmentBinding

    override fun bind(binding: ChartScreenFragmentBinding) {
        this.binding = binding
        setupToolbar()
        setupObservers()
    }

    private fun setupToolbar() {
        binding.chartScreenT.setNavigationIcon(R.drawable.ic_back)
        binding.chartScreenT.setNavigationOnClickListener { viewModel.onBack() }
    }

    private fun setupObservers() {
        viewModel.chart.observe(
            lifecycleOwner(),
            ::onChartState,
        )
    }

    private fun onChartState(
        success: ChartState.Success,
    ) {
        with(success.data) {
            // TODO: set data
        }
    }

}