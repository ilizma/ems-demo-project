package com.ilizma.ems.flow.navigator

import androidx.navigation.NavController
import com.ilizma.ems.view.fragment.DashboardScreenFragmentDirections

class ChartNavigatorImp(
    private val navController: NavController,
) : ChartNavigator {

    override fun navigate(id: String) {
        DashboardScreenFragmentDirections.goFromDashboardToChart(id)
            .let { navController.navigate(it) }
    }

}