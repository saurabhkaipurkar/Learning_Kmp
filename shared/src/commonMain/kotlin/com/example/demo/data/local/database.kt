package com.example.demo.data.local

import androidx.room.RoomDatabase

fun getDatabase(
    builder: RoomDatabase.Builder<TodoDatabase>
): TodoDatabase {
    return builder
        .fallbackToDestructiveMigration(true)
        .build()
}