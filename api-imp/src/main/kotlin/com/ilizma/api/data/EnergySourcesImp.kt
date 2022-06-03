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

class EnergySourcesImp(
    private val context: Context,
    private val moshi: Moshi,
) : EnergySources {

    @OptIn(ExperimentalStdlibApi::class)
    override fun getHistoricData(
    ): Single<HistoricData> = getJsonStringFromAsset(
        context = context,
        fileName = HISTORIC_DATA_JSON_FILE_NAME
    ).let { moshi.adapter<HistoricData>().fromJson(it) }
        ?.let { Single.just(it) }
        ?: throw IllegalArgumentException("Malformed $HISTORIC_DATA_JSON_FILE_NAME")

    @OptIn(ExperimentalStdlibApi::class)
    override fun getLiveData(
    ): Single<LiveData> = getJsonStringFromAsset(
        context = context,
        fileName = LIVE_DATA_JSON_FILE_NAME
    ).let { moshi.adapter<LiveData>().fromJson(it) }
        ?.let { Single.just(it) }
        ?: throw IllegalArgumentException("Malformed $LIVE_DATA_JSON_FILE_NAME")

}