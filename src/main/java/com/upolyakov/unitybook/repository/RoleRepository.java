package com.upolyakov.unitybook.repository;

import com.upolyakov.unitybook.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByname(String name);
}
