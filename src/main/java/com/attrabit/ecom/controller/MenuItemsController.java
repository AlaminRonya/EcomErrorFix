package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.MenuItems;
import com.attrabit.ecom.service.MenuItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemsController {

    @Autowired
    private MenuItemsService menuItemsService;

    @GetMapping
    public ResponseEntity<List<MenuItems>> getAllMenuItems() {
        List<MenuItems> menuItems = menuItemsService.getAllMenuItems();
        return new ResponseEntity<>(menuItems, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItems> getMenuItemsById(@PathVariable Long id) {
        Optional<MenuItems> menuItems = menuItemsService.getMenuItemsById(id);
        return menuItems.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<MenuItems> saveMenuItems(@RequestBody MenuItems menuItems) {
        MenuItems savedMenuItems = menuItemsService.saveMenuItems(menuItems);
        return new ResponseEntity<>(savedMenuItems, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItems> updateMenuItems(@PathVariable Long id, @RequestBody MenuItems menuItems) {
        Optional<MenuItems> existingMenuItems = menuItemsService.getMenuItemsById(id);
        if (existingMenuItems.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        menuItems.setId(id);
        MenuItems updatedMenuItems = menuItemsService.saveMenuItems(menuItems);
        return new ResponseEntity<>(updatedMenuItems, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMenuItems(@PathVariable Long id) {
        Optional<MenuItems> existingMenuItems = menuItemsService.getMenuItemsById(id);
        if (existingMenuItems.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        menuItemsService.deleteMenuItems(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
