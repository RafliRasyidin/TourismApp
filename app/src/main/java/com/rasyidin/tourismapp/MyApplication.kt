package com.rasyidin.tourismapp

import android.app.Application
import com.rasyidin.tourismapp.core.di.*
import com.rasyidin.tourismapp.di.AppComponent
import com.rasyidin.tourismapp.di.DaggerAppComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

open class MyApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}