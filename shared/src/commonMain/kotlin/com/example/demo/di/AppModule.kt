package com.example.demo.di

import com.example.demo.data.local.TodoDatabase
import com.example.demo.presentation.TodoViewModel
import com.example.demo.repository.TodoRepository
import org.koin.dsl.module

val appModule = module {
    single {
        get<TodoDatabase>().todoDao()
    }

    single {
        TodoRepository(get())
    }

    single {
        TodoViewModel(get())
    }
}