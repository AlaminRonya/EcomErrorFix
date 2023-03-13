package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.Pages;
import com.attrabit.ecom.service.PagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pages")
public class PagesController {
    @Autowired
    private PagesService pagesService;

    @GetMapping("")
    public List<Pages> getAllPages() {
        return pagesService.getAllPages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pages> getPageById(@PathVariable Long id) {
        Optional<Pages> page = pagesService.getPageById(id);
        return page.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public Pages createPage(@RequestBody Pages page) {
        return pagesService.createPage(page);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pages> updatePage(@PathVariable Long id, @RequestBody Pages page) {
        Pages updatedPage = pagesService.updatePage(id, page);
        if (updatedPage != null) {
            return ResponseEntity.ok().body(updatedPage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePage(@PathVariable Long id) {
        pagesService.deletePage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
