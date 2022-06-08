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
    @Assisted private val _chartState: MutableLiveData<PresentationChartState.Success>,
    @Assisted(ERROR_ASSISTED) private val _error: MutableLiveData<String>,
    @Assisted private val _navigationAction: SingleLiveEvent<ChartScreenNavigationAction>,
) : ChartScreenViewModel() {

    override val chart: LiveData<PresentationChartState.Success> = _chartState
    override val error: LiveData<String> = _error
    override val navigationAction: LiveData<ChartScreenNavigationAction> = _navigationAction

    init {
        getChart()
    }

    override fun getChart() {
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
        when (state) {
            is ChartState.Error -> _error.postValue(state.message)
            is ChartState.Success -> mapper.from(state)
                .let { _chartState.postValue(it) }
        }
    }

}
