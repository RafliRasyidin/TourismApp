package com.rasyidin.tourismapp.core.di

import com.rasyidin.tourismapp.core.domain.usecase.TourismInteractor
import com.rasyidin.tourismapp.core.domain.usecase.TourismUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
    @Binds
    abstract fun provideTourismUseCase(tourismInteractor: TourismInteractor): TourismUseCase
}