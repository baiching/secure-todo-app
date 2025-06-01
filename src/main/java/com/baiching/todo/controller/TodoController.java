package com.baiching.todo.controller;

import com.baiching.todo.entity.Todo;
import com.baiching.todo.entity.User;
import com.baiching.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> createTodo(
            @RequestBody Todo todo,
            @AuthenticationPrincipal User user) {
        Todo createdTodo = todoService.createTodo(todo, user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTodo.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdTodo);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getUserTodos(@AuthenticationPrincipal User user){
        return ResponseEntity.ok(todoService.getTodos(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id, @AuthenticationPrincipal User user){
        return ResponseEntity.ok(todoService.getUserTodoById(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(
            @PathVariable Long id,
            @AuthenticationPrincipal User user) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
