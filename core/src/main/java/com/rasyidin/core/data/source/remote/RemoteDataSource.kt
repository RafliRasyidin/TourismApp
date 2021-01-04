package com.rasyidin.core.data.source.remote

import android.util.Log
import com.rasyidin.core.data.source.remote.network.ApiResponse
import com.rasyidin.core.data.source.remote.network.ApiService
import com.rasyidin.core.data.source.remote.response.TourismResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllTourism(): Flow<ApiResponse<List<TourismResponse>>> {

        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.places
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.places))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    /*
    RxJava
    fun getAllTourism(): Flowable<ApiResponse<List<TourismResponse>>> {
        val resultData = PublishSubject.create<ApiResponse<List<TourismResponse>>>()

        val client = apiService.getList()
        client.apply {
            subscribeOn(Schedulers.computation())
            observeOn(AndroidSchedulers.mainThread())
            take(1)
            subscribe({ response ->
                val dataArray = response.places
                resultData.onNext(if (dataArray.isNotEmpty()) ApiResponse.Success(dataArray) else ApiResponse.Empty)
            }, { error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("RemoteDataSource", error.message.toString())
            })
        }
        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }*/
}