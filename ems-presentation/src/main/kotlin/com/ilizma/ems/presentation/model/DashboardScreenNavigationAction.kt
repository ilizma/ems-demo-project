package com.ilizma.ems.presentation.model

sealed class DashboardScreenNavigationAction {

    object Back : DashboardScreenNavigationAction()

    data class Detail(val id: String) : DashboardScreenNavigationAction()

}