package com.rasyidin.core.domain.usecase

import com.rasyidin.core.data.Resource
import com.rasyidin.core.domain.model.Tourism
import com.rasyidin.core.domain.repository.ITourismRepository
import kotlinx.coroutines.flow.Flow

class TourismInteractor(private val tourismRepository: ITourismRepository) : TourismUseCase {

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