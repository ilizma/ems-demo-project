package com.ilizma.dashboard.domain.usecase

import com.ilizma.dashboard.domain.model.DashboardState
import com.ilizma.dashboard.domain.repository.DashboardRepository
import io.reactivex.rxjava3.core.Single

class DashboardUseCaseImp(
    private val repository: DashboardRepository,
) : DashboardUseCase {

    override fun invoke(
    ): Single<DashboardState> = repository.get()

}