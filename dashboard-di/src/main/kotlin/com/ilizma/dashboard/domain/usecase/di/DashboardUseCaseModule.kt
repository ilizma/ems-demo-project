package com.ilizma.dashboard.domain.usecase.di

import com.ilizma.dashboard.domain.repository.DashboardRepository
import com.ilizma.dashboard.domain.usecase.DashboardUseCase
import com.ilizma.dashboard.domain.usecase.DashboardUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object DashboardUseCaseModule {

    @Provides
    fun provideDashboardUseCase(
        repository: DashboardRepository,
    ): DashboardUseCase = DashboardUseCaseImp(
        repository = repository,
    )

}