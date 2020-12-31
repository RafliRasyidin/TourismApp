package com.rasyidin.tourismapp.core.data.source.local.room

import androidx.room.*
import com.rasyidin.tourismapp.core.data.source.local.entity.TourismEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow

@Dao
interface TourismDao {

    @Query("SELECT * FROM tourism")
    fun getAllTourism(): Flow<List<TourismEntity>>

    @Query("SELECT * FROM tourism WHERE isFavorite = 1")
    fun getFavoriteTourism(): Flow<List<TourismEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTourism(tourism: List<TourismEntity>)

    @Update
    fun updateFavoriteTourism(tourism: TourismEntity)

    /*
    RxJava
    @Query("SELECT * FROM tourism")
    fun getAllTourism(): Flowable<List<TourismEntity>>

    @Query("SELECT * FROM tourism WHERE isFavorite = 1")
    fun getFavoriteTourism(): Flowable<List<TourismEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTourism(tourism: List<TourismEntity>): Completable

    @Update
    fun updateFavoriteTourism(tourism: TourismEntity)*/
}