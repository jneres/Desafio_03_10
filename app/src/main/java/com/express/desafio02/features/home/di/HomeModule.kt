package com.express.desafio02.features.home.di

import com.express.desafio02.core.abstractions.network.createWebService
import com.express.desafio02.features.home.data.HomeRepository
import com.express.desafio02.features.home.data.HomeService
import com.express.desafio02.features.home.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {

    factory {
        HomeRepository(get())
    }

    factory<HomeService> {
        createWebService()
    }

    viewModel {
        HomeViewModel(get())
    }

}