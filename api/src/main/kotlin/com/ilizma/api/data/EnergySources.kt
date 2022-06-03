package com.ilizma.api.data

import com.ilizma.api.model.HistoricData
import com.ilizma.api.model.LiveData
import io.reactivex.rxjava3.core.Single

interface EnergySources {

    fun getHistoricData(): Single<HistoricData>

    fun getLiveData(): Single<LiveData>

}