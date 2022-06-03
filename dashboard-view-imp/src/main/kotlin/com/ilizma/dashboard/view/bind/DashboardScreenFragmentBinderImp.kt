package com.ilizma.dashboard.view.bind

import com.ilizma.dashboard.view.databinding.DashboardScreenFragmentBinding

class DashboardScreenFragmentBinderImp : DashboardScreenFragmentBinder {

    private lateinit var binding: DashboardScreenFragmentBinding

    override fun bind(binding: DashboardScreenFragmentBinding) {
        this.binding = binding
    }

}