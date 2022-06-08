package com.ilizma.ems.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.ilizma.ems.domain.model.DashboardState
import com.ilizma.ems.domain.usecase.DashboardUseCase
import com.ilizma.ems.presentation.mapper.DashboardStateMapper
import com.ilizma.ems.presentation.model.DashboardScreenNavigationAction.Back
import com.ilizma.ems.presentation.model.DashboardScreenNavigationAction.Detail
import com.ilizma.presentation.SingleLiveEvent
import com.ilizma.test.executor.InstantExecutorExtension
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import com.ilizma.ems.presentation.model.DashboardState as PresentationDashboardState

@ExtendWith(InstantExecutorExtension::class)
internal class DashboardScreenViewModelImpTest {

    @RelaxedMockK
    private lateinit var useCase: DashboardUseCase

    @RelaxedMockK
    private lateinit var mapper: DashboardStateMapper

    @RelaxedMockK
    private lateinit var backgroundScheduler: Scheduler

    @RelaxedMockK
    private lateinit var compositeDisposable: CompositeDisposable

    private lateinit var viewModel: DashboardScreenViewModel

    init {
        MockKAnnotations.init(this)
    }

    private fun initViewModel() {
        viewModel = DashboardScreenViewModelImp(
            useCase = useCase,
            mapper = mapper,
            backgroundScheduler = backgroundScheduler,
            compositeDisposable = compositeDisposable,
            _dashboardState = MutableLiveData(),
            _error = MutableLiveData(),
            _navigationAction = SingleLiveEvent(),
        )
    }

    @Nested
    inner class Init {

        @Test
        fun `given a Success DashboardState, when init is executed, then the liveData value should be the expected`() {
            // given
            val state = mockk<DashboardState.Success>()
            val expected = mockk<PresentationDashboardState.Success>()
            every { useCase() } returns Single.just(state)
            every { mapper.from(state) } returns expected

            // when
            initViewModel()

            // then
            assertEquals(expected, viewModel.dashboardState.value)
        }

        @Test
        fun `given a Error DashboardState, when init is executed, then the liveData value should be the expected`() {
            // given
            val expected = "errorMessage"
            val state = mockk<DashboardState.Error>()
            every { useCase() } returns Single.just(state)
            every { state.message } returns expected

            // when
            initViewModel()

            // then
            assertEquals(expected, viewModel.error.value)
        }

    }

    @Nested
    inner class OpenDetail {

        @Test
        fun `given initialized viewModel, when openDetail is executed, then the liveData value should be the expected`() {
            // given
            val expected = Detail
            initViewModel()

            // when
            viewModel.openDetail()

            // then
            assertEquals(expected, viewModel.navigationAction.value)
        }

    }

    @Nested
    inner class OnBack {

        @Test
        fun `given initialized viewModel, when onBack is executed, then the liveData value should be the expected`() {
            // given
            val expected = Back
            initViewModel()

            // when
            viewModel.onBack()

            // then
            assertEquals(expected, viewModel.navigationAction.value)
        }

    }

}