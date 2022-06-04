package com.ilizma.api.data

import android.content.Context
import com.ilizma.api.extension.getJsonStringFromAsset
import com.ilizma.api.model.HistoricData
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.mockkStatic
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.BufferedReader

internal class EnergySourcesApiImpTest {

    @RelaxedMockK
    private lateinit var context: Context

    @RelaxedMockK
    private lateinit var moshi: Moshi

    private lateinit var api: EnergySourcesApi

    init {
        MockKAnnotations.init(this)
        mockkStatic(Single::class)
    }

    @BeforeEach
    fun setup() {
        api = EnergySourcesApiImp(
            context = context,
            moshi = moshi,
        )

        val bufferedReader = mockk<BufferedReader>()
        every { context.assets.open(any()).bufferedReader() } returns bufferedReader
        every { bufferedReader.readText() } returns mockk()
    }

    @Nested
    inner class GetHistoricData {

        @ExperimentalStdlibApi
        @Test
        fun `given expected HistoricData list, when getHistoricDataList is called, then result should be the expected`() {
            // given
            val expected = mockk<List<HistoricData>>()
            val jsonAdapter = mockk<JsonAdapter<List<HistoricData>>>(relaxed = true)
            val singleHistoricDataList = mockk<Single<List<HistoricData>>>()
            every { context.getJsonStringFromAsset(any()) } returns mockk()
            every { moshi.adapter<List<HistoricData>>() } returns jsonAdapter
            every { jsonAdapter.fromJson(any<String>()) } returns expected
            every { Single.just(expected) } returns singleHistoricDataList

            // when
            val resultObserver = api.getHistoricDataList()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}