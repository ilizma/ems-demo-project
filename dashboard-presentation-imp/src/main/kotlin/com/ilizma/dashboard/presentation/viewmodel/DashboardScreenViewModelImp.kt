package com.ilizma.dashboard.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilizma.dashboard.domain.model.DashboardState
import com.ilizma.dashboard.domain.usecase.DashboardUseCase
import com.ilizma.dashboard.presentation.mapper.DashboardStateMapper
import com.ilizma.dashboard.presentation.model.DashboardScreenNavigationAction
import com.ilizma.dashboard.presentation.model.DashboardScreenNavigationAction.Back
import com.ilizma.dashboard.presentation.model.DashboardScreenNavigationAction.Detail
import com.ilizma.dashboard.presentation.viewmodel.factory.ERROR_ASSISTED
import com.ilizma.presentation.SingleLiveEvent
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import com.ilizma.dashboard.presentation.model.DashboardState as PresentationDashboardState

class DashboardScreenViewModelImp @AssistedInject constructor(
    useCase: DashboardUseCase,
    @Assisted private val mapper: DashboardStateMapper,
    @Assisted private val backgroundScheduler: Scheduler,
    @Assisted private val compositeDisposable: CompositeDisposable,
    @Assisted private val _dashboardState: MutableLiveData<PresentationDashboardState.Success>,
    @Assisted(ERROR_ASSISTED) private val _error: MutableLiveData<String>,
    @Assisted private val _navigationAction: SingleLiveEvent<DashboardScreenNavigationAction>,
) : DashboardScreenViewModel() {

    override val dashboardState: LiveData<PresentationDashboardState.Success> = _dashboardState
    override val error: LiveData<String> = _error
    override val navigationAction: LiveData<DashboardScreenNavigationAction> = _navigationAction

    init {
        useCase()
            .subscribeOn(backgroundScheduler)
            .observeOn(backgroundScheduler)
            .subscribe(::onDashboardState)
            .addTo(compositeDisposable)
    }

    override fun onClick(id: String) {
        Detail(id)
            .let { _navigationAction.postValue(it) }
    }

    override fun onBack() {
        _navigationAction.postValue(Back)
    }

    private fun onDashboardState(
        state: DashboardState,
    ) {
        when(state){
            is DashboardState.Error -> _error.postValue(state.message)
            is DashboardState.Success -> mapper.from(state)
                .let { _dashboardState.postValue(it) }
        }
    }

}
