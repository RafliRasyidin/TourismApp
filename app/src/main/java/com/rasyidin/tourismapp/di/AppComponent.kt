package com.rasyidin.tourismapp.di

import com.rasyidin.tourismapp.core.di.AppModule
import com.rasyidin.tourismapp.core.di.CoreComponent
import com.rasyidin.tourismapp.detail.DetailTourismActivity
import com.rasyidin.tourismapp.favorite.FavoriteFragment
import com.rasyidin.tourismapp.home.HomeFragment
import dagger.Component

@AppScope
@Component(dependencies = [CoreComponent::class], modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(activity: DetailTourismActivity)

}