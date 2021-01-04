package com.rasyidin.tourismapp

import android.app.Application
import com.rasyidin.core.di.databaseModule
import com.rasyidin.core.di.networkModule
import com.rasyidin.core.di.repositoryModule
import com.rasyidin.tourismapp.core.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}