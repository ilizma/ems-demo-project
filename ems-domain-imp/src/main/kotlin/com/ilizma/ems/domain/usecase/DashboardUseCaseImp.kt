package com.ilizma.ems.domain.usecase

import com.ilizma.ems.domain.model.DashboardState
import com.ilizma.ems.domain.repository.EmsRepository
import io.reactivex.rxjava3.core.Single

class DashboardUseCaseImp(
    private val repository: EmsRepository,
) : DashboardUseCase {

    override fun invoke(
    ): Single<DashboardState> = repository.getDashboardState()

}