package com.ilizma.ems.domain.usecase

import com.ilizma.ems.domain.model.ChartState
import io.reactivex.rxjava3.core.Single

interface ChartUseCase {

    operator fun invoke(): Single<ChartState>

}