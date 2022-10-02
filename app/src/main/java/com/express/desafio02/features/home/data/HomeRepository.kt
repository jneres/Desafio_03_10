package com.express.desafio02.features.home.data


import com.express.desafio02.core.abstractions.network.ResponseWrapper
import com.express.desafio02.core.abstractions.network.apiCall
import com.express.desafio02.features.home.data.model.HomeResponse

class HomeRepository(private val service: HomeService) {
    suspend fun getItens(): ResponseWrapper<List<HomeResponse>> {
        return apiCall {
            service.getItems()
        }
    }

    suspend fun getItensDetails(idItem: Int): ResponseWrapper<HomeResponse> {
        return apiCall {
            service.getListDetails(idItem)
        }
    }

    suspend fun setDetails(eventId: Int, name: String, email: String): ResponseWrapper<String> {
        return apiCall {
            service.setDetails(eventId, name, email)
        }
    }


}