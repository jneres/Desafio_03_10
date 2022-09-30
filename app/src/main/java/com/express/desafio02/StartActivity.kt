package com.express.desafio02

import android.app.Application
import com.express.desafio02.features.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class StartupApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@StartupApplication)
            modules(
                homeModule
            )
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }

}