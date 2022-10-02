package com.express.desafio02.features.home.data

import com.express.desafio02.features.home.data.model.HomeResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface HomeService {
    @GET("events/")
    suspend fun getItems(): List<HomeResponse>

    @GET("events/{id}")
    suspend fun getListDetails(@Path("id") idItem: Int): HomeResponse

    @POST("events/")
    suspend fun setDetails(
        @Path("id") idItem: Int,
        @Path("name") name: String,
        @Path("email") email: String
    ): String
}