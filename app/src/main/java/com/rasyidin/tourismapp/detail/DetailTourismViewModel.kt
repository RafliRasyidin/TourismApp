package com.rasyidin.tourismapp.detail

import androidx.lifecycle.ViewModel
import com.rasyidin.core.domain.model.Tourism
import com.rasyidin.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(private val tourismUseCase: TourismUseCase) : ViewModel() {

    fun setFavoriteTourism(tourism: Tourism, state: Boolean) =
        tourismUseCase.setFavoriteTourism(tourism, state)
}