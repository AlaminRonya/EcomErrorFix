package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemsRepository extends JpaRepository<MenuItems, Long> {
}
