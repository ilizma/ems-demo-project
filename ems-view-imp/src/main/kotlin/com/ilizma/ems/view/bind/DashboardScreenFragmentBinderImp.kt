package com.ilizma.ems.view.bind

import androidx.lifecycle.LifecycleOwner
import com.ilizma.ems.presentation.model.DashboardState
import com.ilizma.ems.presentation.viewmodel.DashboardScreenViewModel
import com.ilizma.ems.view.databinding.DashboardScreenFragmentBinding

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
        viewModel.dashboard.observe(
            lifecycleOwner(),
            ::onDashboardState,
        )
    }

    private fun onDashboardState(
        success: DashboardState.Success,
    ) {
        with(success.data) {
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