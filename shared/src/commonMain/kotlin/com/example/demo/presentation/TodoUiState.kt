package com.example.demo.presentation

import com.example.demo.data.local.TodoEntity

data class TodoUiState(
    val todos: List<TodoEntity> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)