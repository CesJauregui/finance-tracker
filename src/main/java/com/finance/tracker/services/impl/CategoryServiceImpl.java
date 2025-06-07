package com.finance.tracker.services.impl;

import com.finance.tracker.dto.CategoryDTO;
import com.finance.tracker.entities.Category;
import com.finance.tracker.entities.User;
import com.finance.tracker.mapper.CategoryMapper;
import com.finance.tracker.repositories.CategoryRepository;
import com.finance.tracker.repositories.UserRepository;
import com.finance.tracker.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

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
    public CategoryDTO createCategory(CategoryDTO category) {
        Category newCategory = new Category();
        newCategory.setNameCategory(category.getNameCategory());
        newCategory.setTypeCategory(category.getTypeCategory());
        User user = userRepository.findById(category.getUserId())
                .orElseThrow(()-> new RuntimeException("No se encontró al usuario"));
        newCategory.setUser(user);
        return CategoryMapper.toDTO(categoryRepository.save(newCategory));
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDTO> getCategoryByUser(User user) {
        return categoryRepository.findByUsername(user.getUsername())
                .stream()
                .map(CategoryMapper::toDTO)
                .toList();
    }
}
