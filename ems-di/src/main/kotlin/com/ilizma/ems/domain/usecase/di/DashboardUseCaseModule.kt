package com.ilizma.ems.domain.usecase.di

import com.ilizma.ems.domain.repository.EmsRepository
import com.ilizma.ems.domain.usecase.DashboardUseCase
import com.ilizma.ems.domain.usecase.DashboardUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object DashboardUseCaseModule {

    @Provides
    fun provideDashboardUseCase(
        repository: EmsRepository,
    ): DashboardUseCase = DashboardUseCaseImp(
        repository = repository,
    )

}