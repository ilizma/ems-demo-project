package com.ilizma.dashboard.data.datasource

import com.ilizma.dashboard.data.model.DashboardState
import io.reactivex.rxjava3.core.Single

interface DashboardDataSource {

    fun get() : Single<DashboardState>

}