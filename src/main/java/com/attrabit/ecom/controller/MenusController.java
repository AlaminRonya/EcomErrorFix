package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.Menus;
import com.attrabit.ecom.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenusController {

    @Autowired
    private MenusService menusService;

    @GetMapping
    public ResponseEntity<List<Menus>> getAllMenus() {
        List<Menus> menus = menusService.getAllMenus();
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menus> getMenuById(@PathVariable Long id) {
        Menus menu = menusService.getMenuById(id);
        if (menu != null) {
            return new ResponseEntity<>(menu, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Menus> createMenu(@RequestBody Menus menu) {
        Menus createdMenu = menusService.createMenu(menu);
        return new ResponseEntity<>(createdMenu, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menus> updateMenu(@PathVariable Long id, @RequestBody Menus menu) {
        Menus updatedMenu = menusService.updateMenu(id, menu);
        if (updatedMenu != null) {
            return new ResponseEntity<>(updatedMenu, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        menusService.deleteMenu(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
