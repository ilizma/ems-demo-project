package com.ilizma.ems.data.model

sealed class DashboardState {

    data class Success(
        val data: LiveData,
    ) : DashboardState()

    data class Error(val message: String) : DashboardState()

}