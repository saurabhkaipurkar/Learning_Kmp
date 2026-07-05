package com.example.demo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.data.local.TodoEntity
import com.example.demo.repository.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TodoViewModel(
    private val repository: TodoRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(TodoUiState())
    val uiState: StateFlow<TodoUiState> = _uiState.asStateFlow()

    init {
        observeTodos()
    }

    private fun observeTodos() {
        viewModelScope.launch {
            repository.getAllTodos().collect { todos ->
                _uiState.update {
                    it.copy(todos = todos)
                }
            }
        }
    }

    fun addTodo(
        title: String
    ) {
        viewModelScope.launch {
            repository.insertTodo(title)
        }
    }

    fun deleteTodo(
        todo: TodoEntity
    ) {
        viewModelScope.launch {
            repository.delete(todo)
        }
    }

    fun updateTodo(todo: TodoEntity) {
        viewModelScope.launch {
            repository.update(todo)
        }
    }

}