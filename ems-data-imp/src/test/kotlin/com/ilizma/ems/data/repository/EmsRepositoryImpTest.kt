package com.ilizma.ems.data.repository

import com.ilizma.ems.data.cache.ChartCache
import com.ilizma.ems.data.cache.DashboardCache
import com.ilizma.ems.data.datasource.EmsDataSource
import com.ilizma.ems.data.mapper.ChartStateMapper
import com.ilizma.ems.data.mapper.DashboardStateMapper
import com.ilizma.ems.domain.model.ChartState
import com.ilizma.ems.domain.model.DashboardState
import com.ilizma.ems.domain.repository.EmsRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import com.ilizma.ems.data.model.ChartState as DataChartState
import com.ilizma.ems.data.model.DashboardState as DataDashboardState

internal class EmsRepositoryImpTest {

    @RelaxedMockK
    private lateinit var dataSource: EmsDataSource

    @RelaxedMockK
    private lateinit var dashboardCache: DashboardCache

    @RelaxedMockK
    private lateinit var chartCache: ChartCache

    @RelaxedMockK
    private lateinit var dashboardStateMapper: DashboardStateMapper

    @RelaxedMockK
    private lateinit var chartStateMapper: ChartStateMapper

    private lateinit var repository: EmsRepository

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        repository = EmsRepositoryImp(
            dataSource = dataSource,
            dashboardCache = dashboardCache,
            chartCache = chartCache,
            dashboardStateMapper = dashboardStateMapper,
            chartStateMapper = chartStateMapper,
        )
    }

    @Nested
    inner class GetDashboardState {

        @Test
        fun `given null dashboardCache, when getDashboardState is called, then result should be the expected`() {
            // given
            val dataDashboardState = mockk<DataDashboardState.Success>()
            val expected = mockk<DashboardState.Success>()
            every { dashboardCache.cache } returns null andThen dataDashboardState
            every { dataSource.getDashboardState() } returns Single.just(dataDashboardState)
            every { dashboardStateMapper.from(dataDashboardState) } returns expected

            // when
            val resultObserver = repository.getDashboardState()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            assertEquals(dashboardCache.cache, dataDashboardState)
            resultObserver.assertValue { it == expected }
        }

        @Test
        fun `given null dashboardCache and Error DataDashboardState, when getDashboardState is called, then result should be the expected`() {
            // given
            val dataDashboardState = mockk<DataDashboardState.Error>()
            val expected = mockk<DashboardState.Error>()
            every { dashboardCache.cache } returns null
            every { dataSource.getDashboardState() } returns Single.just(dataDashboardState)
            every { dashboardStateMapper.from(dataDashboardState) } returns expected

            // when
            val resultObserver = repository.getDashboardState()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

        @Test
        fun `given a dashboardCache, when getDashboardState is called, then result should be the expected`() {
            // given
            val dataDashboardState = mockk<DataDashboardState.Success>()
            val expected = mockk<DashboardState.Success>()
            every { dashboardCache.cache } returns dataDashboardState
            every { dashboardStateMapper.from(dataDashboardState) } returns expected

            // when
            val resultObserver = repository.getDashboardState()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            verify(exactly = 0) { dataSource.getDashboardState() }
            resultObserver.assertValue { it == expected }
        }

    }

    @Nested
    inner class GetChartState {

        @Test
        fun `given null dashboardCache, when getChartState is called, then result should be the expected`() {
            // given
            val dataChartState = mockk<DataChartState.Success>()
            val expected = mockk<ChartState.Success>()
            every { chartCache.cache } returns null andThen dataChartState
            every { dataSource.getChartState() } returns Single.just(dataChartState)
            every { chartStateMapper.from(dataChartState) } returns expected

            // when
            val resultObserver = repository.getChartState()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            assertEquals(chartCache.cache, dataChartState)
            resultObserver.assertValue { it == expected }
        }

        @Test
        fun `given null dashboardCache and Error ChartState, when getChartState is called, then result should be the expected`() {
            // given
            val dataChartState = mockk<DataChartState.Error>()
            val expected = mockk<ChartState.Error>()
            every { chartCache.cache } returns null
            every { dataSource.getChartState() } returns Single.just(dataChartState)
            every { chartStateMapper.from(dataChartState) } returns expected

            // when
            val resultObserver = repository.getChartState()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

        @Test
        fun `given a dashboardCache, when getChartState is called, then result should be the expected`() {
            // given
            val dataChartState = mockk<DataChartState.Success>()
            val expected = mockk<ChartState.Success>()
            every { chartCache.cache } returns dataChartState
            every { chartStateMapper.from(dataChartState) } returns expected

            // when
            val resultObserver = repository.getChartState()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            verify(exactly = 0) { dataSource.getChartState() }
            resultObserver.assertValue { it == expected }
        }

    }

}