package com.ilizma.dashboard.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ilizma.dashboard.view.R
import com.ilizma.dashboard.view.bind.DashboardScreenFragmentBinder
import com.ilizma.dashboard.view.databinding.DashboardScreenFragmentBinding
import com.ilizma.view.binding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashboardScreenFragment : Fragment(R.layout.dashboard_screen_fragment) {

    @Inject
    internal lateinit var binder: DashboardScreenFragmentBinder

    private val binding by viewBinding(DashboardScreenFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binder.bind(binding)
    }

}
