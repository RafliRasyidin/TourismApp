package com.rasyidin.tourismapp.core.domain.usecase

import com.rasyidin.tourismapp.core.data.Resource
import com.rasyidin.tourismapp.core.domain.model.Tourism
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow

interface TourismUseCase {

    fun getAllTourism(): Flow<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

    /*
    RxJava
    fun getAllTourism(): Flowable<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flowable<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)*/
}