package com.rasyidin.tourismapp.favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rasyidin.tourismapp.core.domain.usecase.TourismUseCase

class FavoriteViewModel @ViewModelInject constructor(tourismUseCase: TourismUseCase) : ViewModel() {

    val favoriteTourism = tourismUseCase.getFavoriteTourism().asLiveData()

    /*
    RxJava
    val favoriteTourism =
        LiveDataReactiveStreams.fromPublisher(tourismUseCase.getFavoriteTourism())*/
}