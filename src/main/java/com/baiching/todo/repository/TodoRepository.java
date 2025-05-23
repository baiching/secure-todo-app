package com.baiching.todo.repository;

import com.baiching.todo.entity.Todo;
import com.baiching.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    // Find all todos by user (for regular users)
    List<Todo> findByUser(User user);

    // Find todos by completion status + user
    List<Todo> findByUserAndCompleted(User user, boolean completed);

    // For admin access to all todos (if needed)
    List<Todo> findAllByOrderByCreatedAtDesc();
}
