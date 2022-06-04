package com.ilizma.dashboard.domain.usecase

import com.ilizma.dashboard.domain.model.DashboardState
import com.ilizma.dashboard.domain.repository.DashboardRepository
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
    private lateinit var repository: DashboardRepository

    private lateinit var dataSource: DashboardUseCase

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    fun setup() {
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
            every { repository.get() } returns Single.just(expected)

            // when
            val resultObserver = repository.get()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}