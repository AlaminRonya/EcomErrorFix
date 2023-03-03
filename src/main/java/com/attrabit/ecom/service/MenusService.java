package com.attrabit.ecom.service;

import com.attrabit.ecom.model.Menus;
import com.attrabit.ecom.repository.MenusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenusService {

    @Autowired
    private MenusRepository menusRepository;

    public List<Menus> getAllMenus() {
        return menusRepository.findAll();
    }

    public Menus getMenuById(Long id) {
        return menusRepository.findById(id).orElse(null);
    }

    public Menus createMenu(Menus menu) {
        return menusRepository.save(menu);
    }

    public Menus updateMenu(Long id, Menus menu) {
        Menus existingMenu = menusRepository.findById(id).orElse(null);
        if (existingMenu != null) {
            existingMenu.setIsActive(menu.getIsActive());
            existingMenu.setCreatedAt(menu.getCreatedAt());
            existingMenu.setUpdatedAt(menu.getUpdatedAt());
            return menusRepository.save(existingMenu);
        }
        return null;
    }

    public void deleteMenu(Long id) {
        menusRepository.deleteById(id);
    }
}
