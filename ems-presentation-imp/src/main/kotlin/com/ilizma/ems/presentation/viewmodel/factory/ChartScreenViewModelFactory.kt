package com.ilizma.ems.presentation.viewmodel.factory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ilizma.ems.presentation.mapper.ChartStateMapper
import com.ilizma.ems.presentation.mapper.HistoricDataMapper
import com.ilizma.presentation.SingleLiveEvent
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ChartScreenViewModelFactory(
    private val viewModelAssistedFactory: ChartScreenViewModelAssistedFactory,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T = viewModelAssistedFactory.create(
        mapper = ChartStateMapper(HistoricDataMapper()),
        backgroundScheduler = Schedulers.io(),
        compositeDisposable = CompositeDisposable(),
        _dashboardState = MutableLiveData(),
        _error = MutableLiveData(),
        _navigationAction = SingleLiveEvent(),
    ) as T

}