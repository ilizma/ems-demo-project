package com.ilizma.ems.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ilizma.ems.view.R
import com.ilizma.ems.view.bind.ChartScreenFragmentBinder
import com.ilizma.ems.view.databinding.ChartScreenFragmentBinding
import com.ilizma.ems.view.router.ChartScreenRouter
import com.ilizma.view.binding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChartScreenFragment : Fragment(R.layout.chart_screen_fragment) {

    @Inject
    internal lateinit var binder: ChartScreenFragmentBinder

    @Inject
    internal lateinit var router: ChartScreenRouter

    private val binding by viewBinding(ChartScreenFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        router.init()
        binder.bind(binding)
    }

}
