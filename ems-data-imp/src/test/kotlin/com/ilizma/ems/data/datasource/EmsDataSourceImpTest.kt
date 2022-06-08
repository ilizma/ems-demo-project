package com.ilizma.ems.data.datasource

import com.ilizma.api.data.EnergySourcesApi
import com.ilizma.api.model.HistoricData
import com.ilizma.api.model.LiveData
import com.ilizma.ems.data.mapper.ChartStateMapper
import com.ilizma.ems.data.mapper.DashboardStateMapper
import com.ilizma.ems.data.model.ChartState
import com.ilizma.ems.data.model.DashboardState
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class EmsDataSourceImpTest {

    @RelaxedMockK
    private lateinit var api: EnergySourcesApi

    @RelaxedMockK
    private lateinit var dashboardMapper: DashboardStateMapper

    @RelaxedMockK
    private lateinit var chartMapper: ChartStateMapper

    private lateinit var dataSource: EmsDataSource
    private val unknownError = "unknownError"

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    fun setup() {
        dataSource = EmsDataSourceImp(
            api = api,
            dashboardMapper = dashboardMapper,
            chartMapper = chartMapper,
            unknownError = unknownError,
        )
    }

    @Nested
    inner class GetDashboardState {

        @Test
        fun `given LiveData, when getDashboardState is called, then result should be the expected`() {
            // given
            val liveData = mockk<LiveData>()
            val expected = mockk<DashboardState.Success>()
            every { api.getLiveData() } returns Single.just(liveData)
            every { dashboardMapper.from(liveData) } returns expected

            // when
            val resultObserver = dataSource.getDashboardState()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

        @Test
        fun `given error, when getDashboardState is called, then result should be the expected`() {
            // given
            val liveData = mockk<IllegalArgumentException>()
            val expected = mockk<DashboardState.Error>()
            every { api.getLiveData() } returns Single.error(liveData)

            // when
            val resultObserver = dataSource.getDashboardState()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

    @Nested
    inner class GetChartState {

        @Test
        fun `given HistoricData list, when getChartState is called, then result should be the expected`() {
            // given
            val historicDataList = mockk<List<HistoricData>>()
            val expected = mockk<ChartState.Success>()
            every { api.getHistoricDataList() } returns Single.just(historicDataList)
            every { chartMapper.from(historicDataList) } returns expected

            // when
            val resultObserver = dataSource.getChartState()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}