package com.ilizma.ems.flow.navigator

import androidx.navigation.NavController

class ChartScreenBackCloseNavigatorImp(
    private val navController: NavController,
) : ChartScreenBackCloseNavigator {

    override fun close() {
        navController.popBackStack()
    }

}