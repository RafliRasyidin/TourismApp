package com.rasyidin.tourismapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rasyidin.tourismapp.core.domain.usecase.TourismUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(tourismUseCase: TourismUseCase) : ViewModel() {

    val tourism = tourismUseCase.getAllTourism().asLiveData()

    // RxJava
    // val tourism = LiveDataReactiveStreams.fromPublisher(tourismUseCase.getAllTourism())
}