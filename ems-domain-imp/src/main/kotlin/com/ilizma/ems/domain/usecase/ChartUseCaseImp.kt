package com.ilizma.ems.domain.usecase

import com.ilizma.ems.domain.model.ChartState
import com.ilizma.ems.domain.repository.EmsRepository
import io.reactivex.rxjava3.core.Single

class ChartUseCaseImp(
    private val repository: EmsRepository,
) : ChartUseCase {

    override fun invoke(
    ): Single<ChartState> = repository.getChartState()

}