package dev.matheushdas.springflix.controller;

import dev.matheushdas.springflix.dto.CategoryResponse;
import dev.matheushdas.springflix.dto.CreateCategoryRequest;
import dev.matheushdas.springflix.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/all")
    private ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id) {
        CategoryResponse category = service.findById(id);
        return category == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(category);
    }

    @PostMapping("/save")
    private ResponseEntity<CategoryResponse> saveCategory(@RequestBody CreateCategoryRequest category) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(category));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
