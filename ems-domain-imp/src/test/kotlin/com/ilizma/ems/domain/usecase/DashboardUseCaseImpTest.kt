package com.ilizma.ems.domain.usecase

import com.ilizma.ems.domain.model.DashboardState
import com.ilizma.ems.domain.repository.EmsRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class DashboardUseCaseImpTest {

    @RelaxedMockK
    private lateinit var repository: EmsRepository

    private lateinit var dataSource: DashboardUseCase

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        dataSource = DashboardUseCaseImp(
            repository,
        )
    }

    @Nested
    inner class Invoke {

        @Test
        fun `given expected DashboardState, when invoked, then result should be the expected`() {
            // given
            val expected = mockk<DashboardState>()
            every { repository.getDashboardState() } returns Single.just(expected)

            // when
            val resultObserver = repository.getDashboardState()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}