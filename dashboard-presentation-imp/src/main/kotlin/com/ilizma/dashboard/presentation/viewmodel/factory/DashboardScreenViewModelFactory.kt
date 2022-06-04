package com.ilizma.dashboard.presentation.viewmodel.factory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ilizma.dashboard.presentation.mapper.DashboardStateMapper
import com.ilizma.dashboard.presentation.mapper.HistoricDataMapper
import com.ilizma.presentation.SingleLiveEvent
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class DashboardScreenViewModelFactory(
    private val dashboardScreenViewModelAssistedFactory: DashboardScreenViewModelAssistedFactory,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T = dashboardScreenViewModelAssistedFactory.create(
        mapper = DashboardStateMapper(HistoricDataMapper()),
        backgroundScheduler = Schedulers.io(),
        compositeDisposable = CompositeDisposable(),
        _dashboardState = MutableLiveData(),
        _error = MutableLiveData(),
        _navigationAction = SingleLiveEvent(),
    ) as T

}