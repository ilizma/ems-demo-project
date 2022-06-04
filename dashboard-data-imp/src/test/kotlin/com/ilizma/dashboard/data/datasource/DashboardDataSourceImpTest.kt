package com.ilizma.dashboard.data.datasource

import com.ilizma.api.data.EnergySourcesApi
import com.ilizma.api.model.HistoricData
import com.ilizma.dashboard.data.mapper.DashboardStateMapper
import com.ilizma.dashboard.data.model.DashboardState
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class DashboardDataSourceImpTest {

    @RelaxedMockK
    private lateinit var api: EnergySourcesApi

    @RelaxedMockK
    private lateinit var mapper: DashboardStateMapper

    private lateinit var dataSource: DashboardDataSource

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    fun setup() {
        dataSource = DashboardDataSourceImp(
            api = api,
            mapper = mapper,
        )
    }

    @Nested
    inner class Get {

        @Test
        fun `given HistoricData list, when get is called, then result should be the expected`() {
            // given
            val historicDataList = mockk<List<HistoricData>>()
            val expected = mockk<DashboardState>()
            every { api.getHistoricDataList() } returns Single.just(historicDataList)
            every { mapper.from(historicDataList) } returns expected

            // when
            val resultObserver = dataSource.get()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}