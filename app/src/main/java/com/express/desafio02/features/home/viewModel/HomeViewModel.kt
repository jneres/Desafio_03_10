package com.express.desafio02.features.home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.express.desafio02.core.abstractions.network.ResponseWrapper
import com.express.desafio02.features.home.data.HomeRepository
import com.express.desafio02.features.home.data.model.HomeResponse
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {

    val homeData = MutableLiveData<List<HomeResponse>?>()
    val homeDataItem = MutableLiveData<HomeResponse?>()
    var loading = MutableLiveData(false)
    var checkin = MutableLiveData<String?>()


    var homeResponse: HomeResponse? = null

    fun getItens() {
        loading.value = true

        viewModelScope.launch {

            val response = repository.getItens()

            when (response) {
                is ResponseWrapper.Success -> {
                    homeData.value = response.value
                }
                else -> {}
            }
        }
        loading.value = false
    }


    fun getItensDetails(idItem: Int) {

        loading.value = true

        viewModelScope.launch {
            val response = repository.getItensDetails(idItem)

            when (response) {
                is ResponseWrapper.Success -> {
                    homeDataItem.value = response.value
                    homeResponse = response.value
                }
                else -> {}
            }
        }

        loading.value = false
    }

    fun setDetails(eventId: String, name: String, email: String) {

        loading.value = true

        viewModelScope.launch {
            val response = repository.setDetails(eventId, name, email)

            when (response) {
                is ResponseWrapper.Success -> {
                    checkin.value = response.value
                }
                else -> {}
            }
        }

        loading.value = false
    }
}



