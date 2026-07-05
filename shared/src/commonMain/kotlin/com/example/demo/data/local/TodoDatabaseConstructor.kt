package com.example.demo.data.local

import androidx.room.RoomDatabaseConstructor

expect object TodoDatabaseConstructor :
    RoomDatabaseConstructor<TodoDatabase> {
    override fun initialize(): TodoDatabase
}