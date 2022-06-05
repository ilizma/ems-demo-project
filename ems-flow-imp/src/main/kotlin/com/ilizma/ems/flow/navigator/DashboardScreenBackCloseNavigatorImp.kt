package com.ilizma.ems.flow.navigator

import android.app.Activity

class DashboardScreenBackCloseNavigatorImp(
    private val activity: Activity
) : DashboardScreenBackCloseNavigator {

    override fun close() {
        activity.finish()
    }

}