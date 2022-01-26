package com.example.todolist.controller;

import com.example.todolist.entity.TodoList;
import com.example.todolist.service.TodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo-list")
@RequiredArgsConstructor
public class TodoListController {

    private final TodoListService todoListService;

    @GetMapping("/{id}")
    public ResponseEntity<TodoList> getTodoList(@PathVariable Integer id) {
        TodoList todoList = todoListService.getTodoList(id);
        return ResponseEntity.ok(todoList);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Void> changeStatus(@PathVariable Integer id, @RequestParam(value = "isDone") Boolean isDone) {
        TodoList todoList = todoListService.getTodoList(id);
        todoList.setIsDone(isDone);
        todoListService.updateTodoList(id, todoList);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<TodoList> createTodoList(@RequestBody TodoList todoList) {
        TodoList createdTodoList = todoListService.createTodoList(todoList);
        return ResponseEntity.ok(createdTodoList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTodoList(@PathVariable Integer id, @RequestBody TodoList todoList) {
        todoListService.updateTodoList(id, todoList);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoList(@PathVariable Integer id) {
        todoListService.deleteTodoList(id);
        return ResponseEntity.noContent().build();
    }
}
