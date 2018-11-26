package com.vaibhavsood.data.repository;

import com.vaibhavsood.data.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
