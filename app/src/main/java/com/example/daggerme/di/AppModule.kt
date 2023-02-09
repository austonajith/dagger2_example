package com.example.daggerme.di

import android.app.Application
import android.content.Context
import com.example.daggerme.utils.NetworkUtils
import com.example.daggerme.utils.PrefHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {
    @Provides
    @Singleton
    fun providesApplication(): Application = application

    @Provides
    @Singleton
    fun providesApplicationContext(): Context = application

    @Provides
    fun providePrefHelper(): PrefHelper {
        return PrefHelper(application.applicationContext)
    }

    @Provides
    fun provideNetworkUtils(): NetworkUtils{
        return NetworkUtils(application.applicationContext)
    }
}