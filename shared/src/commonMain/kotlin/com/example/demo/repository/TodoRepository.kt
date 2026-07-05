package com.example.demo.repository

import com.example.demo.data.local.TodoDao
import com.example.demo.data.local.TodoEntity
import kotlinx.coroutines.flow.Flow

class TodoRepository(
    private val todoDao: TodoDao
) {
    fun getAllTodos(): Flow<List<TodoEntity>> {
        return todoDao.getAllTodos()
    }

    suspend fun insertTodo(title: String) {
        todoDao.insertTodo(TodoEntity(title = title))
    }

    suspend fun update(todo: TodoEntity) {
        todoDao.update(todo)
    }

    suspend fun delete(todo: TodoEntity) {
        todoDao.delete(todo)
    }
}