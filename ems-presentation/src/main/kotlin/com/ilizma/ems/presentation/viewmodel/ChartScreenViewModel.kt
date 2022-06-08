package com.ilizma.ems.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ilizma.ems.presentation.model.ChartScreenNavigationAction
import com.ilizma.ems.presentation.model.ChartState

abstract class ChartScreenViewModel : ViewModel() {

    abstract val chart: LiveData<ChartState>

    abstract val error: LiveData<ChartState.Error>

    abstract val navigationAction: LiveData<ChartScreenNavigationAction>

    abstract fun getChart()

    abstract fun onBack()

}