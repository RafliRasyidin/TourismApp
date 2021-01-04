package com.rasyidin.core.data

import com.rasyidin.core.data.source.local.LocalDataSource
import com.rasyidin.core.data.source.remote.RemoteDataSource
import com.rasyidin.core.data.source.remote.network.ApiResponse
import com.rasyidin.core.data.source.remote.response.TourismResponse
import com.rasyidin.core.domain.model.Tourism
import com.rasyidin.core.domain.repository.ITourismRepository
import com.rasyidin.core.utils.AppExecutors
import com.rasyidin.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TourismRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ITourismRepository {

    override fun getAllTourism(): Flow<Resource<List<Tourism>>> =
        object : NetworkBoundResource<List<Tourism>, List<TourismResponse>>() {
            override fun loadFromDB(): Flow<List<Tourism>> {
                return localDataSource.getAllTourism().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Tourism>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<TourismResponse>>> {
                return remoteDataSource.getAllTourism()
            }

            override suspend fun saveCallResult(data: List<TourismResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asFlow()

    override fun getFavoriteTourism(): Flow<List<Tourism>> {
        return localDataSource.getFavoriteTourism().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
    }

    /*
    RxJava
    override fun getFavoriteTourism(): Flowable<List<Tourism>> {
         return localDataSource.getFavoriteTourism().map {
             DataMapper.mapEntitiesToDomain(it)
         }
     }

     override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
         val tourismEntity = DataMapper.mapDomainToEntity(tourism)
         appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
     }

     override fun getAllTourism(): Flowable<Resource<List<Tourism>>> =
         object : NetworkBoundResource<List<Tourism>, List<TourismResponse>>() {
             override fun loadFromDB(): Flowable<List<Tourism>> {
                 return localDataSource.getAllTourism().map {
                     DataMapper.mapEntitiesToDomain(it)
                 }
             }

             override fun shouldFetch(data: List<Tourism>?): Boolean {
                 return data == null || data.isEmpty()
             }

             override fun createCall(): Flowable<ApiResponse<List<TourismResponse>>> {
                 return remoteDataSource.getAllTourism()
             }

             override fun saveCallResult(data: List<TourismResponse>) {
                 val tourismList = DataMapper.mapResponsesToEntities(data)
                 localDataSource.insertTourism(tourismList)
                     .subscribeOn(Schedulers.io())
                     .observeOn(AndroidSchedulers.mainThread())
                     .subscribe()
             }
         }.asFlow()

     override fun getFavoriteTourism(): Flowable<List<Tourism>> {
         return localDataSource.getFavoriteTourism().map {
             DataMapper.mapEntitiesToDomain(it)
         }
     }

     override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
         val tourismEntity = DataMapper.mapDomainToEntity(tourism)
         appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
     }*/
}