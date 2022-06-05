package com.ilizma.ems.domain.usecase

import com.ilizma.ems.domain.model.DashboardState
import io.reactivex.rxjava3.core.Single

interface DashboardUseCase {

    operator fun invoke() : Single<DashboardState>

}