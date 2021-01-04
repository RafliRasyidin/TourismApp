package com.rasyidin.tourismapp.core.di

import com.rasyidin.core.domain.usecase.TourismInteractor
import com.rasyidin.core.domain.usecase.TourismUseCase
import com.rasyidin.tourismapp.detail.DetailTourismViewModel
import com.rasyidin.tourismapp.favorite.FavoriteViewModel
import com.rasyidin.tourismapp.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TourismUseCase> { TourismInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailTourismViewModel(get()) }
}