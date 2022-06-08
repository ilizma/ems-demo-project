package com.ilizma.ems.presentation.viewmodel.factory

import androidx.lifecycle.MutableLiveData
import com.ilizma.ems.presentation.mapper.ChartStateMapper
import com.ilizma.ems.presentation.model.ChartScreenNavigationAction
import com.ilizma.ems.presentation.model.ChartState
import com.ilizma.ems.presentation.viewmodel.ChartScreenViewModelImp
import com.ilizma.ems.presentation.viewmodel.factory.const.ERROR_ASSISTED
import com.ilizma.presentation.SingleLiveEvent
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable

@AssistedFactory
interface ChartScreenViewModelAssistedFactory {

    fun create(
        mapper: ChartStateMapper,
        backgroundScheduler: Scheduler,
        compositeDisposable: CompositeDisposable,
        _dashboardState: MutableLiveData<ChartState>,
        @Assisted(ERROR_ASSISTED) _error: MutableLiveData<ChartState.Error>,
        _navigationAction: SingleLiveEvent<ChartScreenNavigationAction>
    ): ChartScreenViewModelImp

}