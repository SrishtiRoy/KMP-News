package com.dsr.kmpnews.android

import android.app.Application
import com.dsr.kmpnews.android.di.databaseModule
import com.dsr.kmpnews.android.di.viewModelsModule
import com.petros.efthymiou.dailypulse.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KMPNew: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule + databaseModule

        startKoin {
            androidContext(this@KMPNew)
            modules(modules)
        }
    }

}