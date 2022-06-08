package com.ilizma.ems.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ilizma.ems.presentation.model.DashboardScreenNavigationAction
import com.ilizma.ems.presentation.model.DashboardState

abstract class DashboardScreenViewModel : ViewModel() {

    abstract val dashboardState: LiveData<DashboardState>

    abstract val error: LiveData<DashboardState.Error>

    abstract val navigationAction: LiveData<DashboardScreenNavigationAction>

    abstract fun getDashboard()

    abstract fun openDetail()

    abstract fun onBack()

}