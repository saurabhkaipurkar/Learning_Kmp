package com.example.demo.database

import androidx.room.RoomDatabase
import com.example.demo.data.local.TodoDatabase

expect class DatabaseFactory {
    fun create(): RoomDatabase.Builder<TodoDatabase>
}