package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.UserRoles;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {
}
