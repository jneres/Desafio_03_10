package com.express.desafio02.features.home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.express.testedesenvolvedorsicredi.core.abstractions.network.ResponseWrapper
import com.express.desafio02.features.home.data.HomeRepository
import com.express.desafio02.features.home.data.model.HomeResponse
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {

    val homeData = MutableLiveData<List<HomeResponse>?>()
    var loading = MutableLiveData(false)

    fun getItens() {
        loading.value = true

        viewModelScope.launch {

            val response = repository.getItensApi()

            when (response) {
                is ResponseWrapper.Success -> {
                    homeData.value = response.value.payload
                }
                else -> {}
            }
        }
        loading.value = false
    }
}