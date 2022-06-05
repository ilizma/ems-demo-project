package com.ilizma.ems.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ilizma.ems.presentation.model.DashboardScreenNavigationAction
import com.ilizma.ems.presentation.model.DashboardState

abstract class DashboardScreenViewModel : ViewModel() {

    abstract val dashboardState: LiveData<DashboardState.Success>

    abstract val error: LiveData<String>

    abstract val navigationAction: LiveData<DashboardScreenNavigationAction>

    abstract fun onClick(id: String)

    abstract fun onBack()

}