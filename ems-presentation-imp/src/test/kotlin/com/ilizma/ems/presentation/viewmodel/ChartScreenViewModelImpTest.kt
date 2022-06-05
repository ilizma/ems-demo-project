package com.ilizma.ems.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.ilizma.ems.domain.model.ChartState
import com.ilizma.ems.domain.usecase.ChartUseCase
import com.ilizma.ems.presentation.mapper.ChartStateMapper
import com.ilizma.ems.presentation.model.ChartScreenNavigationAction.Back
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
import com.ilizma.ems.presentation.model.ChartState as PresentationChartState

@ExtendWith(InstantExecutorExtension::class)
internal class ChartScreenViewModelImpTest {

    @RelaxedMockK
    private lateinit var useCase: ChartUseCase

    @RelaxedMockK
    private lateinit var mapper: ChartStateMapper

    @RelaxedMockK
    private lateinit var backgroundScheduler: Scheduler

    @RelaxedMockK
    private lateinit var compositeDisposable: CompositeDisposable

    private lateinit var viewModel: ChartScreenViewModel

    init {
        MockKAnnotations.init(this)
    }

    private fun initViewModel() {
        viewModel = ChartScreenViewModelImp(
            useCase = useCase,
            mapper = mapper,
            backgroundScheduler = backgroundScheduler,
            compositeDisposable = compositeDisposable,
            _chartState = MutableLiveData(),
            _error = MutableLiveData(),
            _navigationAction = SingleLiveEvent(),
        )
    }

    @Nested
    inner class Init {

        @Test
        fun `given a Success ChartState, when init is executed, then the liveData value should be the expected`() {
            // given
            val state = mockk<ChartState.Success>()
            val expected = mockk<PresentationChartState.Success>()
            every { useCase() } returns Single.just(state)
            every { mapper.from(state) } returns expected

            // when
            initViewModel()

            // then
            assertEquals(expected, viewModel.chart.value)
        }

        @Test
        fun `given a Error ChartState, when init is executed, then the liveData value should be the expected`() {
            // given
            val expected = "errorMessage"
            val state = mockk<ChartState.Error>()
            every { useCase() } returns Single.just(state)
            every { state.message } returns expected

            // when
            initViewModel()

            // then
            assertEquals(expected, viewModel.error.value)
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