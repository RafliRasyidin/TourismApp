package com.rasyidin.core.data.source.remote.network

import com.rasyidin.core.data.source.remote.response.ListTourismResponse
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