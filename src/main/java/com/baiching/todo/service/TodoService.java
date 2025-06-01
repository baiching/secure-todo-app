package com.baiching.todo.service;

import com.baiching.todo.entity.Todo;
import com.baiching.todo.entity.User;
import com.baiching.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo todo, User user){
        todo.setUser(user);
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Todo todo){
        return todoRepository.findById(todo.getId())
                .filter(existingTodo -> existingTodo.getId().equals(todo.getId()))
                .map(existingTodo -> {
                    existingTodo.setTitle(todo.getTitle());
                    existingTodo.setDescription(todo.getDescription());
                    return todoRepository.save(existingTodo);
                })
                .orElseThrow(() -> new RuntimeException("Todo not found!"));
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> getTodos(User user) {
        return todoRepository.findByUser(user);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
}
