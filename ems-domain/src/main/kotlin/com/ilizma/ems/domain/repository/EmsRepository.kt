package com.ilizma.ems.domain.repository

import com.ilizma.ems.domain.model.ChartState
import com.ilizma.ems.domain.model.DashboardState
import io.reactivex.rxjava3.core.Single

interface EmsRepository {

    fun getDashboardState(): Single<DashboardState>

    fun getChartState(): Single<ChartState>

}