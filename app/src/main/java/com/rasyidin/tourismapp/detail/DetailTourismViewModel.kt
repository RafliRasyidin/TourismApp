package com.rasyidin.tourismapp.detail

import androidx.lifecycle.ViewModel
import com.rasyidin.tourismapp.core.domain.model.Tourism
import com.rasyidin.tourismapp.core.domain.usecase.TourismUseCase
import javax.inject.Inject

class DetailTourismViewModel @Inject constructor(private val tourismUseCase: TourismUseCase) : ViewModel() {

    fun setFavoriteTourism(tourism: Tourism, state: Boolean) =
        tourismUseCase.setFavoriteTourism(tourism, state)
}