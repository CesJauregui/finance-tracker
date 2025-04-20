package com.finance.tracker.services;

import com.finance.tracker.dto.CategoryDTO;
import com.finance.tracker.entities.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAll();
    CategoryDTO getCategoryById(Long id);
    CategoryDTO createCategory(Category category);
    void deleteCategory(Long id);
}
