package com.baiching.todo.repository;

import com.baiching.todo.entity.Role;
import com.baiching.todo.entity.Todo;
import com.baiching.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    // For admin dashboard (if needed)
    long countByRole(Role role);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
