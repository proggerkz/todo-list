package com.example.todolist.service;

import com.example.todolist.entity.TodoList;
import com.example.todolist.repository.TodoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoListServiceImpl implements TodoListService {

    private final TodoListRepository todoListRepository;

    @Override
    public TodoList createTodoList(TodoList todoList) {
        return todoListRepository.save(todoList);
    }

    @Override
    public TodoList getTodoList(Integer id) {
        Optional<TodoList> todoList = todoListRepository.findById(id);
        if (todoList.isPresent()) {
            return todoList.get();
        } else {
            throw new RuntimeException("There are no todo list with id = " + id);
        }
    }

    @Override
    public void updateTodoList(Integer id, TodoList updateList) {
        TodoList todoList = getTodoList(id);
        updateFields(todoList, updateList);
        todoListRepository.save(todoList);
    }

    @Override
    public void deleteTodoList(Integer id) {
        todoListRepository.deleteById(id);
    }

    public void updateFields(TodoList currentEntity, TodoList updateEntity) {
        currentEntity.setDate(updateEntity.getDate() != null ? updateEntity.getDate() : currentEntity.getDate());
        currentEntity.setDescription(updateEntity.getDescription() != null ? updateEntity.getDescription() : currentEntity.getDescription());
        currentEntity.setName(updateEntity.getName() != null ? updateEntity.getName() : currentEntity.getName());
        currentEntity.setPriority(updateEntity.getPriority() != null ? updateEntity.getPriority() : currentEntity.getPriority());
    }
}
