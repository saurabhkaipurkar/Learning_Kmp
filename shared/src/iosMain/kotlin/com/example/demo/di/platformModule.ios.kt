package com.example.demo.di

import com.example.demo.database.DatabaseFactory
import org.koin.dsl.module

actual val platformModule = module {

    single {
        DatabaseFactory()
    }
}