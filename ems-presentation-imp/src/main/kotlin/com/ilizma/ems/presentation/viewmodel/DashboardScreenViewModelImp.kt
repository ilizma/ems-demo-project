package com.ilizma.ems.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilizma.ems.domain.model.DashboardState
import com.ilizma.ems.domain.usecase.DashboardUseCase
import com.ilizma.ems.presentation.mapper.DashboardStateMapper
import com.ilizma.ems.presentation.model.DashboardScreenNavigationAction
import com.ilizma.ems.presentation.model.DashboardScreenNavigationAction.Back
import com.ilizma.ems.presentation.model.DashboardScreenNavigationAction.Detail
import com.ilizma.ems.presentation.viewmodel.factory.const.ERROR_ASSISTED
import com.ilizma.presentation.SingleLiveEvent
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import com.ilizma.ems.presentation.model.DashboardState as PresentationDashboardState

class DashboardScreenViewModelImp @AssistedInject constructor(
    private val useCase: DashboardUseCase,
    @Assisted private val mapper: DashboardStateMapper,
    @Assisted private val backgroundScheduler: Scheduler,
    @Assisted private val compositeDisposable: CompositeDisposable,
    @Assisted private val _dashboardState: MutableLiveData<PresentationDashboardState>,
    @Assisted(ERROR_ASSISTED) private val _error: MutableLiveData<PresentationDashboardState.Error>,
    @Assisted private val _navigationAction: SingleLiveEvent<DashboardScreenNavigationAction>,
) : DashboardScreenViewModel() {

    override val dashboardState: LiveData<PresentationDashboardState> = _dashboardState
    override val error: LiveData<PresentationDashboardState.Error> = _error
    override val navigationAction: LiveData<DashboardScreenNavigationAction> = _navigationAction

    init {
        getDashboard()
    }

    override fun getDashboard() {
        _dashboardState.postValue(PresentationDashboardState.Loading)
        useCase()
            .subscribeOn(backgroundScheduler)
            .observeOn(backgroundScheduler)
            .subscribe(::onDashboardState)
            .addTo(compositeDisposable)
    }

    override fun openDetail() {
        _navigationAction.postValue(Detail)
    }

    override fun onBack() {
        _navigationAction.postValue(Back)
    }

    private fun onDashboardState(
        state: DashboardState,
    ) {
        mapper.from(state)
            .let { manageState(it) }

    }

    private fun manageState(
        state: PresentationDashboardState
    ) {
        when (state) {
            is PresentationDashboardState.Error -> _error.postValue(state)
            is PresentationDashboardState.Success -> _dashboardState.postValue(state)
        }
    }

}
