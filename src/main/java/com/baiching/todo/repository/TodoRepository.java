package com.baiching.todo.repository;

import com.baiching.todo.entity.Todo;
import com.baiching.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    // Find all todos by user (for regular users)
    List<Todo> findByUser(User user);

    Optional<Todo> findById(Long id);

    // Find todos by completion status + user
    List<Todo> findByUserAndCompleted(User user, boolean completed);

    // For admin access to all todos (if needed)
    List<Todo> findAllByOrderByCreatedAtDesc();

    Todo findByIdAndUser(Long id, User user);
}
