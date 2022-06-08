package com.ilizma.ems.presentation.viewmodel.factory

import androidx.lifecycle.MutableLiveData
import com.ilizma.ems.presentation.mapper.DashboardStateMapper
import com.ilizma.ems.presentation.model.DashboardScreenNavigationAction
import com.ilizma.ems.presentation.model.DashboardState
import com.ilizma.ems.presentation.viewmodel.DashboardScreenViewModelImp
import com.ilizma.ems.presentation.viewmodel.factory.const.ERROR_ASSISTED
import com.ilizma.presentation.SingleLiveEvent
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable

@AssistedFactory
interface DashboardScreenViewModelAssistedFactory {

    fun create(
        mapper: DashboardStateMapper,
        backgroundScheduler: Scheduler,
        compositeDisposable: CompositeDisposable,
        _dashboardState: MutableLiveData<DashboardState>,
        @Assisted(ERROR_ASSISTED) _error: MutableLiveData<DashboardState.Error>,
        _navigationAction: SingleLiveEvent<DashboardScreenNavigationAction>
    ): DashboardScreenViewModelImp

}