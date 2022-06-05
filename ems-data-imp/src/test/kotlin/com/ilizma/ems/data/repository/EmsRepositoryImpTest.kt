package com.ilizma.ems.data.repository

import com.ilizma.ems.data.cache.DashboardCache
import com.ilizma.ems.data.datasource.EmsDataSource
import com.ilizma.ems.data.mapper.DashboardStateMapper
import com.ilizma.ems.domain.model.DashboardState
import com.ilizma.ems.data.model.DashboardState as DataDashboardState
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

class EmsRepositoryImpTest {

    @RelaxedMockK
    private lateinit var dataSource: EmsDataSource

    @RelaxedMockK
    private lateinit var cache: DashboardCache

    @RelaxedMockK
    private lateinit var mapper: DashboardStateMapper

    private lateinit var repository: EmsRepository

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    fun setup() {
        repository = EmsRepositoryImp(
            dataSource = dataSource,
            cache = cache,
            mapper = mapper,
        )
    }

    @Nested
    inner class Get {

        @Test
        fun `given null cache, when get is called, then result should be the expected`() {
            // given
            val dataDashboardState = mockk<DataDashboardState>()
            val expected = mockk<DashboardState>()
            every { cache.cache } returns null
            every { dataSource.get() } returns Single.just(dataDashboardState)
            every { mapper.from(dataDashboardState) } returns expected

            // when
            val resultObserver = repository.get()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            assertEquals(cache.cache, expected)
            resultObserver.assertValue { it == expected }
        }

        @Test
        fun `given a cache, when get is called, then result should be the expected`() {
            // given
            val dataDashboardState = mockk<DataDashboardState>()
            val expected = mockk<DashboardState>()
            every { cache.cache } returns dataDashboardState
            every { mapper.from(dataDashboardState) } returns expected

            // when
            val resultObserver = repository.get()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            verify(exactly = 0) { dataSource.get() }
            resultObserver.assertValue { it == expected }
        }

    }

}