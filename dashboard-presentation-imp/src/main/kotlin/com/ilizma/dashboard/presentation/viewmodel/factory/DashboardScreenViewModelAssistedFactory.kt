package com.ilizma.dashboard.presentation.viewmodel.factory

import androidx.lifecycle.MutableLiveData
import com.ilizma.dashboard.presentation.mapper.DashboardStateMapper
import com.ilizma.presentation.SingleLiveEvent
import com.ilizma.dashboard.presentation.model.DashboardScreenNavigationAction
import com.ilizma.dashboard.presentation.model.DashboardState
import com.ilizma.dashboard.presentation.viewmodel.DashboardScreenViewModelImp
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable

const val ERROR_ASSISTED = "ERROR_ASSISTED"

@AssistedFactory
interface DashboardScreenViewModelAssistedFactory {

    fun create(
        mapper: DashboardStateMapper,
        backgroundScheduler: Scheduler,
        compositeDisposable: CompositeDisposable,
        _dashboardState: MutableLiveData<DashboardState.Success>,
        @Assisted(ERROR_ASSISTED) _error: MutableLiveData<String>,
        _navigationAction: SingleLiveEvent<DashboardScreenNavigationAction>
    ): DashboardScreenViewModelImp

}