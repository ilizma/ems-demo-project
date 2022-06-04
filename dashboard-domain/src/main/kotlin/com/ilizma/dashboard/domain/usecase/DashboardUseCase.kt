package com.ilizma.dashboard.domain.usecase

import com.ilizma.dashboard.domain.model.DashboardState
import io.reactivex.rxjava3.core.Single

interface DashboardUseCase {

    operator fun invoke() : Single<DashboardState>

}