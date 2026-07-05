package com.example.demo.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(
    appDeclaration: KoinApplication.() -> Unit = {}
) {
    startKoin {
        appDeclaration()

        modules(
            appModule,
            databaseModule
        )
    }
}