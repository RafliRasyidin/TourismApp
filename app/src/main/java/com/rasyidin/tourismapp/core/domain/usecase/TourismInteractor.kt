package com.rasyidin.tourismapp.core.domain.usecase

import com.rasyidin.tourismapp.core.data.Resource
import com.rasyidin.tourismapp.core.domain.model.Tourism
import com.rasyidin.tourismapp.core.domain.repository.ITourismRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TourismInteractor @Inject constructor(private val tourismRepository: ITourismRepository) : TourismUseCase {

    override fun getAllTourism(): Flow<Resource<List<Tourism>>> {
        return tourismRepository.getAllTourism()
    }

    override fun getFavoriteTourism(): Flow<List<Tourism>> {
        return tourismRepository.getFavoriteTourism()
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        tourismRepository.setFavoriteTourism(tourism, state)
    }
}