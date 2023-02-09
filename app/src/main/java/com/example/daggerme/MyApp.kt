package com.example.daggerme

import android.app.Application
import com.example.daggerme.di.AppModule
import com.example.daggerme.di.ApplicationComponent
import com.example.daggerme.di.DaggerApplicationComponent
import com.example.daggerme.utils.NetworkUtils

class MyApp : Application() {
    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerApplicationComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

}