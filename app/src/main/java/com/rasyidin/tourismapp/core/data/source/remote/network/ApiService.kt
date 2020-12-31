package com.rasyidin.tourismapp.core.data.source.remote.network

import com.rasyidin.tourismapp.core.data.source.remote.response.ListTourismResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiService {

    @GET("list")
    suspend fun getList(): ListTourismResponse

    /*
    RxJava
    @GET("list")
    fun getList(): Flowable<ListTourismResponse>
    */


}