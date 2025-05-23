package com.baiching.todo.repository;

import com.baiching.todo.entity.Todo;
import com.baiching.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    // Find todos by completion status + user
    List<Todo> findByUserAndCompleted(User user, boolean completed);

    // For admin access to all todos (if needed)
    List<Todo> findAllByOrderByCreatedAtDesc();

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
