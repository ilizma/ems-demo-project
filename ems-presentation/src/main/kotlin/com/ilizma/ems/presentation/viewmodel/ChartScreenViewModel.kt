package com.ilizma.ems.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ilizma.ems.presentation.model.ChartScreenNavigationAction
import com.ilizma.ems.presentation.model.ChartState

abstract class ChartScreenViewModel : ViewModel() {

    abstract val chart: LiveData<ChartState.Success>

    abstract val error: LiveData<String>

    abstract val navigationAction: LiveData<ChartScreenNavigationAction>

    abstract fun getChart()

    abstract fun onBack()

}