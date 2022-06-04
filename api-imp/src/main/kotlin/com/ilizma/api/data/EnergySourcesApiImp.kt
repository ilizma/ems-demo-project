package com.ilizma.api.data

import android.content.Context
import com.ilizma.api.extension.getJsonStringFromAsset
import com.ilizma.api.model.HistoricData
import com.ilizma.api.model.LiveData
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import io.reactivex.rxjava3.core.Single

private const val HISTORIC_DATA_JSON_FILE_NAME = "historic_data.json"
private const val LIVE_DATA_JSON_FILE_NAME = "live_data.json"

class EnergySourcesApiImp(
    private val context: Context,
    private val moshi: Moshi,
) : EnergySourcesApi {

    @OptIn(ExperimentalStdlibApi::class)
    override fun getHistoricDataList(
    ): Single<List<HistoricData>> = context.getJsonStringFromAsset(HISTORIC_DATA_JSON_FILE_NAME)
        .let { moshi.adapter<List<HistoricData>>().fromJson(it) }
        ?.let { Single.just(it) }
        ?: throw IllegalArgumentException("Malformed $HISTORIC_DATA_JSON_FILE_NAME")

    @OptIn(ExperimentalStdlibApi::class)
    override fun getLiveData(
    ): Single<LiveData> = context.getJsonStringFromAsset(LIVE_DATA_JSON_FILE_NAME)
        .let { moshi.adapter<LiveData>().fromJson(it) }
        ?.let { Single.just(it) }
        ?: throw IllegalArgumentException("Malformed $LIVE_DATA_JSON_FILE_NAME")

}