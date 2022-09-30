package com.express.desafio02.features.home.data

import com.express.desafio02.core.abstractions.network.BaseResponse
import com.express.desafio02.features.home.data.model.HomeResponse
import retrofit2.http.GET

interface HomeService {
    @GET("events/")
    suspend fun getList(): BaseResponse<List<HomeResponse>>

}