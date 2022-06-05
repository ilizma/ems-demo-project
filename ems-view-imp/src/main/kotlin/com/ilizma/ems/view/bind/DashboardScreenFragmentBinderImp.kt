package com.ilizma.ems.view.bind

import androidx.lifecycle.LifecycleOwner
import com.ilizma.ems.presentation.model.DashboardState
import com.ilizma.ems.presentation.viewmodel.DashboardScreenViewModel
import com.ilizma.ems.view.adapter.DashboardAdapter
import com.ilizma.ems.view.adapter.factory.DashboardAdapterFactory
import com.ilizma.ems.view.databinding.DashboardScreenFragmentBinding

class DashboardScreenFragmentBinderImp(
    viewModelLazy: Lazy<DashboardScreenViewModel>,
    private val lifecycleOwner: () -> LifecycleOwner,
    adapterFactory: DashboardAdapterFactory,
) : DashboardScreenFragmentBinder {

    private val viewModel by viewModelLazy
    private val adapter: DashboardAdapter by lazy { adapterFactory.create() }
    private lateinit var binding: DashboardScreenFragmentBinding

    override fun bind(binding: DashboardScreenFragmentBinding) {
        this.binding = binding
        initRecyclerView()
        setupObservers()
    }

    private fun initRecyclerView() {
        binding.dashboardScreenFragmentRv.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.dashboardState.observe(
            lifecycleOwner(),
        ) { onDashboardState(it) }
    }

    private fun onDashboardState(
        success: DashboardState.Success,
    ) {
        adapter.submitList(success.historicData)
    }

}