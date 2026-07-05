package com.example.demo.di

import com.example.demo.data.local.getDatabase
import com.example.demo.database.DatabaseFactory
import org.koin.dsl.module

val databaseModule = module {
    single {
        getDatabase(get<DatabaseFactory>().create())
    }
}