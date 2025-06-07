package com.finance.tracker.controllers;

import com.finance.tracker.dto.CategoryDTO;
import com.finance.tracker.entities.Category;
import com.finance.tracker.entities.User;
import com.finance.tracker.exceptions.InvalidCategoryTypeException;
import com.finance.tracker.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getCategories(@AuthenticationPrincipal User user) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoryByUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<?> postCategory(@Valid @RequestBody CategoryDTO category) {
        try {
            CategoryDTO newCategory = categoryService.createCategory(category);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newCategory.getId())
                    .toUri();

            return ResponseEntity.created(location).body(newCategory);
        } catch (InvalidCategoryTypeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateKeyException("El registro ya existe con la clave " + category.getNameCategory());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
