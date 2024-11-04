package dev.matheushdas.springflix.controller;

import dev.matheushdas.springflix.dto.CategoryDTO;
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
    private ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        CategoryDTO category = service.findById(id);
        return category == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(category);
    }

    @PostMapping("/save")
    private ResponseEntity<CategoryDTO> saveCategory(@RequestBody CategoryDTO category) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(category));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
