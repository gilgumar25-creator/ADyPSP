package com.salesianos.dam.primerejemplo.controller;

import com.salesianos.dam.primerejemplo.model.Category;
import com.salesianos.dam.primerejemplo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return ResponseEntity.status(201)
                .body(categoryService.addCategory(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable Long id,
            @RequestBody Category category) {
        return ResponseEntity.ok(categoryService.updateCategory(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}