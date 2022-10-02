package com.express.desafio02.features.home.data

import com.express.desafio02.features.home.data.model.Checkin
import com.express.desafio02.features.home.data.model.HomeResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface HomeService {
    @GET("events/")
    suspend fun getItems(): List<HomeResponse>

    @GET("events/{id}")
    suspend fun getListDetails(@Path("id") idItem: Int): HomeResponse

    @POST("checkin/")
    suspend fun setDetails(
        @Body request: Checkin
    ): String
}


