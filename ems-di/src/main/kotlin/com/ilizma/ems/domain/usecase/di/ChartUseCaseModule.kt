package com.ilizma.ems.domain.usecase.di

import com.ilizma.ems.domain.repository.EmsRepository
import com.ilizma.ems.domain.usecase.ChartUseCase
import com.ilizma.ems.domain.usecase.ChartUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object ChartUseCaseModule {

    @Provides
    fun provideChartUseCase(
        repository: EmsRepository,
    ): ChartUseCase = ChartUseCaseImp(
        repository = repository,
    )

}