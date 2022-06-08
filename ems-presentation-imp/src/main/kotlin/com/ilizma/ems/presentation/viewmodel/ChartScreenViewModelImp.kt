package com.ilizma.ems.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilizma.ems.domain.model.ChartState
import com.ilizma.ems.domain.usecase.ChartUseCase
import com.ilizma.ems.presentation.mapper.ChartStateMapper
import com.ilizma.ems.presentation.model.ChartScreenNavigationAction
import com.ilizma.ems.presentation.model.ChartScreenNavigationAction.Back
import com.ilizma.ems.presentation.viewmodel.factory.const.ERROR_ASSISTED
import com.ilizma.presentation.SingleLiveEvent
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import com.ilizma.ems.presentation.model.ChartState as PresentationChartState

class ChartScreenViewModelImp @AssistedInject constructor(
    private val useCase: ChartUseCase,
    @Assisted private val mapper: ChartStateMapper,
    @Assisted private val backgroundScheduler: Scheduler,
    @Assisted private val compositeDisposable: CompositeDisposable,
    @Assisted private val _chartState: MutableLiveData<PresentationChartState>,
    @Assisted(ERROR_ASSISTED) private val _error: MutableLiveData<PresentationChartState.Error>,
    @Assisted private val _navigationAction: SingleLiveEvent<ChartScreenNavigationAction>,
) : ChartScreenViewModel() {

    override val chart: LiveData<PresentationChartState> = _chartState
    override val error: LiveData<PresentationChartState.Error> = _error
    override val navigationAction: LiveData<ChartScreenNavigationAction> = _navigationAction

    init {
        getChart()
    }

    override fun getChart() {
        _chartState.postValue(PresentationChartState.Loading)
        useCase()
            .subscribeOn(backgroundScheduler)
            .observeOn(backgroundScheduler)
            .subscribe(::onChartState)
            .addTo(compositeDisposable)
    }

    override fun onBack() {
        _navigationAction.postValue(Back)
    }

    private fun onChartState(
        state: ChartState,
    ) {
        mapper.from(state)
            .let { manageState(it) }

    }

    private fun manageState(
        state: PresentationChartState
    ) {
        when (state) {
            is PresentationChartState.Error -> _error.postValue(state)
            is PresentationChartState.Success -> _chartState.postValue(state)
        }
    }

}
