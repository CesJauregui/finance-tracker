package com.finance.tracker.services.impl;

import com.finance.tracker.dto.CategoryDTO;
import com.finance.tracker.entities.Category;
import com.finance.tracker.exceptions.InvalidCategoryTypeException;
import com.finance.tracker.mapper.CategoryMapper;
import com.finance.tracker.repositories.CategoryRepository;
import com.finance.tracker.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toDTO)
                .toList();
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper::toDTO)
                .orElseThrow(()-> new RuntimeException("No se encontró la categoría"));
    }

    @Override
    public CategoryDTO createCategory(Category category) {

        if (!category.getTypeCategoryList().contains(category.getTypeCategory())) {
            throw new InvalidCategoryTypeException("Tipo de categoría no válido: " + category.getTypeCategory());
        }
        Category newCategory = new Category();
        newCategory.setNameCategory(category.getNameCategory());
        newCategory.setTypeCategory(category.getTypeCategory());

        return CategoryMapper.toDTO(categoryRepository.save(newCategory));
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
