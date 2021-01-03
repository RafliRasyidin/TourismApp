package com.rasyidin.tourismapp.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rasyidin.tourismapp.core.domain.usecase.TourismUseCase

class HomeViewModel @ViewModelInject constructor(tourismUseCase: TourismUseCase) : ViewModel() {

    val tourism = tourismUseCase.getAllTourism().asLiveData()

    // RxJava
    // val tourism = LiveDataReactiveStreams.fromPublisher(tourismUseCase.getAllTourism())
}