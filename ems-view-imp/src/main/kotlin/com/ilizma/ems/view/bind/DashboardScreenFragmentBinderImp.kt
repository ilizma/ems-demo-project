package com.ilizma.ems.view.bind

import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import com.ilizma.ems.presentation.model.DashboardState
import com.ilizma.ems.presentation.viewmodel.DashboardScreenViewModel
import com.ilizma.ems.view.databinding.DashboardScreenFragmentBinding
import com.ilizma.resources.R
import com.ilizma.view.extensions.snackbar

class DashboardScreenFragmentBinderImp(
    viewModelLazy: Lazy<DashboardScreenViewModel>,
    private val lifecycleOwner: () -> LifecycleOwner,
) : DashboardScreenFragmentBinder {

    private val viewModel by viewModelLazy
    private lateinit var binding: DashboardScreenFragmentBinding

    override fun bind(binding: DashboardScreenFragmentBinding) {
        this.binding = binding
        setupListener()
        setupObserver()
    }

    private fun setupListener() {
        binding.dashboardScreenCvStatistics.setOnClickListener { viewModel.openDetail() }
    }

    private fun setupObserver() {
        viewModel.dashboardState.observe(
            lifecycleOwner(),
            ::onDashboardState,
        )
        viewModel.error.observe(
            lifecycleOwner(),
            ::onError,
        )
    }

    private fun onDashboardState(
        state: DashboardState,
    ) {
        binding.dashboardScreenILoading
            .dashboardScreenLoadingSflContent.isVisible = state == DashboardState.Loading
        binding.dashboardScreenSvContent.isVisible = state != DashboardState.Loading
        when (state) {
            is DashboardState.Success -> with(state.data) {
                binding.dashboardScreenTvQuasarChargerDischarged.text = totalEnergy.toString()
                binding.dashboardScreenTvQuasarChargerCharged.text = currentEnergy.toString()
                binding.dashboardScreenTvSolarPower.text = solarPower.toString()
                binding.dashboardScreenTvQuasarsPower.text = quasarsPower.toString()
                binding.dashboardScreenTvGridPower.text = gridPower.toString()
                binding.dashboardScreenTvBuildingDemand.text = buildingDemand.toString()
                binding.dashboardScreenTvStatistics.text = systemSoc.toString()
            }
        }

    }

    private fun onError(
        error: DashboardState.Error,
    ) {
        binding.root.snackbar(
            title = error.message,
            action = binding.root.context.getString(R.string.retry),
        ) { viewModel.getDashboard() }
    }

}