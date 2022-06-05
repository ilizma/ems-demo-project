package com.ilizma.ems.data.datasource

import com.ilizma.ems.data.model.ChartState
import com.ilizma.ems.data.model.DashboardState
import io.reactivex.rxjava3.core.Single

interface EmsDataSource {

    fun getDashboardState(): Single<DashboardState>

    fun getChartState(): Single<ChartState>

}