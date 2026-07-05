package com.example.demo.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.demo.data.local.TodoDatabase

actual class DatabaseFactory(
    private val context: Context
) {
    actual fun create(): RoomDatabase.Builder<TodoDatabase> {
        return Room.databaseBuilder(
            context.applicationContext,
            TodoDatabase::class.java,
            "todo.db"
        )
    }
}