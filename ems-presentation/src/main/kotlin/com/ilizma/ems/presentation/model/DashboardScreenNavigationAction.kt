package com.ilizma.ems.presentation.model

sealed class DashboardScreenNavigationAction {

    object Back : DashboardScreenNavigationAction()

    object Detail : DashboardScreenNavigationAction()

}