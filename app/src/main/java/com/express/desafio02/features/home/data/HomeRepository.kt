package com.express.desafio02.features.home.data


import com.express.desafio02.core.abstractions.network.apiCall
import com.express.desafio02.core.abstractions.network.BaseResponse
import com.express.testedesenvolvedorsicredi.core.abstractions.network.ResponseWrapper
import com.express.desafio02.features.home.data.model.HomeResponse

class HomeRepository(private val service: HomeService) {
    suspend fun getItensApi(): ResponseWrapper<List<HomeResponse>> {
        return apiCall {
            service.getList()
        }
    }
}