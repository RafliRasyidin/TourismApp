package com.rasyidin.tourismapp.core.di

import com.rasyidin.tourismapp.core.data.TourismRepository
import com.rasyidin.tourismapp.core.domain.repository.ITourismRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(tourismRepository: TourismRepository): ITourismRepository
}