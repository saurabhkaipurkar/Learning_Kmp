package com.example.demo.data.local

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TodoEntity::class], version = 1, exportSchema = false)
@ConstructedBy(TodoDatabaseConstructor::class)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao
}