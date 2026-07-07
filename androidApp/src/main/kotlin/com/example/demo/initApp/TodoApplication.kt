package com.example.demo.initApp

import android.app.Application
import com.example.demo.di.initKoin
import org.koin.android.ext.koin.androidContext

class TodoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@TodoApplication)
        }
    }
}