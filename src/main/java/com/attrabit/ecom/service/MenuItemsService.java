package com.attrabit.ecom.service;

import com.attrabit.ecom.model.MenuItems;
import com.attrabit.ecom.repository.MenuItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemsService {

    @Autowired
    private MenuItemsRepository menuItemsRepository;

    public List<MenuItems> getAllMenuItems() {
        return menuItemsRepository.findAll();
    }

    public Optional<MenuItems> getMenuItemsById(Long id) {
        return menuItemsRepository.findById(id);
    }

    public MenuItems saveMenuItems(MenuItems menuItems) {
        return menuItemsRepository.save(menuItems);
    }

    public void deleteMenuItems(Long id) {
        menuItemsRepository.deleteById(id);
    }

}
