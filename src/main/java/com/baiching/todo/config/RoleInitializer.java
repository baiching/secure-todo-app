package com.baiching.todo.config;

import com.baiching.todo.entity.ERole;
import com.baiching.todo.entity.Role;
import com.baiching.todo.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class RoleInitializer {
    private final RoleRepository roleRepository;

    public RoleInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void initializeRoles(){
        for (ERole role : ERole.values()) {
            if (!roleRepository.existsByName(role)) {
                roleRepository.save(new Role(role));
            }
        }
    }
}
