package com.example.todolist.service;

import com.example.todolist.entity.TodoList;

public interface TodoListService {

    TodoList createTodoList(TodoList todoList);

    TodoList getTodoList(Integer id);

    void updateTodoList(Integer id, TodoList updateList);

    void deleteTodoList(Integer id);
}
