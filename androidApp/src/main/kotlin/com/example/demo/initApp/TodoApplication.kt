package com.example.demo.initApp

import android.app.Application
import com.example.demo.database.DatabaseFactory
import com.example.demo.di.initKoin
import org.koin.dsl.module

class TodoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            modules(
                module {
                    single {
                        DatabaseFactory(
                            applicationContext
                        )
                    }
                }
            )
        }
    }
}