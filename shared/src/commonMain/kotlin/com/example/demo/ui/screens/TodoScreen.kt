package com.example.demo.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.demo.presentation.TodoViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TodoScreen(
    vm: TodoViewModel = koinViewModel()
) {

    val state by vm.uiState.collectAsStateWithLifecycle()
    var todoText by remember { mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row {

            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = todoText,
                onValueChange = {
                    todoText = it
                },
                placeholder = {
                    Text("Enter Todo")
                }
            )

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            Button(
                onClick = {

                    if (todoText.isNotBlank()) {

                        vm.addTodo(todoText)

                        todoText = ""
                    }
                }
            ) {
                Text("ADD")
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        LazyColumn {

            items(state.todos) { todo ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement =
                            Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = todo.title
                        )

                        TextButton(
                            onClick = {
                                vm.deleteTodo(todo)
                            }
                        ) {
                            Text("Delete")
                        }
                    }
                }
            }
        }
    }
}