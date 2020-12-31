package com.rasyidin.tourismapp.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rasyidin.tourismapp.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val favoriteTourism = tourismUseCase.getFavoriteTourism().asLiveData()

    /*
    RxJava
    val favoriteTourism =
        LiveDataReactiveStreams.fromPublisher(tourismUseCase.getFavoriteTourism())*/
}