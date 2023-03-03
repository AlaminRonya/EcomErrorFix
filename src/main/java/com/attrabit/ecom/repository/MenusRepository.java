package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.Menus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenusRepository extends JpaRepository<Menus, Long> {
}
