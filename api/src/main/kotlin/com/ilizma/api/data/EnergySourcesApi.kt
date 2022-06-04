package com.ilizma.api.data

import com.ilizma.api.model.HistoricData
import com.ilizma.api.model.LiveData
import io.reactivex.rxjava3.core.Single

interface EnergySourcesApi {

    fun getHistoricDataList(): Single<List<HistoricData>>

    fun getLiveData(): Single<LiveData>

}