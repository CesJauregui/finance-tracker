package com.finance.tracker.services;

import com.finance.tracker.dto.CategoryDTO;
import com.finance.tracker.entities.Category;
import com.finance.tracker.entities.User;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAll();
    CategoryDTO getCategoryById(Long id);
    CategoryDTO createCategory(CategoryDTO category);
    void deleteCategory(Long id);
    List<CategoryDTO> getCategoryByUser(User user);
}
