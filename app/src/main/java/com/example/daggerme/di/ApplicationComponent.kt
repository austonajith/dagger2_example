package com.example.daggerme.di

import com.example.daggerme.MainActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}