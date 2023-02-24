package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findRolesByPermissions(String permission);
}
