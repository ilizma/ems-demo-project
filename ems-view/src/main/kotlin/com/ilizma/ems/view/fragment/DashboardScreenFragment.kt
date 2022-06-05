package com.ilizma.ems.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ilizma.ems.view.R
import com.ilizma.ems.view.bind.DashboardScreenFragmentBinder
import com.ilizma.ems.view.databinding.DashboardScreenFragmentBinding
import com.ilizma.ems.view.router.DashboardScreenRouter
import com.ilizma.view.binding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashboardScreenFragment : Fragment(R.layout.dashboard_screen_fragment) {

    @Inject
    internal lateinit var binder: DashboardScreenFragmentBinder

    @Inject
    internal lateinit var router: DashboardScreenRouter

    private val binding by viewBinding(DashboardScreenFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        router.init()
        binder.bind(binding)
    }

}
