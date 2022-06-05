package com.ilizma.ems.domain.model

sealed class DashboardState {

    data class Success(
        val data: LiveData,
    ) : DashboardState()

    data class Error(val message: String) : DashboardState()

}