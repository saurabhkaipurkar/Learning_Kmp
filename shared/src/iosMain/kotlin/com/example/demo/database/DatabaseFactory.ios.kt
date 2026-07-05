package com.example.demo.database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.demo.data.local.TodoDatabase
import platform.Foundation.NSHomeDirectory

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<TodoDatabase> {
        val dbFile = NSHomeDirectory() + "/todo.db"
        return Room.databaseBuilder<TodoDatabase>(
            name = dbFile
        )
    }
}