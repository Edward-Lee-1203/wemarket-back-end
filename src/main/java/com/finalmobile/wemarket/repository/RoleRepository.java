package com.finalmobile.wemarket.repository;

import com.finalmobile.wemarket.models.ERole;
import com.finalmobile.wemarket.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
