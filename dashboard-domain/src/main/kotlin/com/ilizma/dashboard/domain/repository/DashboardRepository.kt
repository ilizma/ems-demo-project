package com.ilizma.dashboard.domain.repository

import com.ilizma.dashboard.domain.model.DashboardState
import io.reactivex.rxjava3.core.Single

interface DashboardRepository {

    fun get() : Single<DashboardState>

}