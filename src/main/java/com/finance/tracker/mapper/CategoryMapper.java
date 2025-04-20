package com.finance.tracker.mapper;

import com.finance.tracker.dto.CategoryDTO;
import com.finance.tracker.entities.Category;

public class CategoryMapper {
    public static CategoryDTO toDTO(Category category){
        return new CategoryDTO(category.getId(), category.getNameCategory(), category.getTypeCategory());
    }

    public static Category toEntity(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setNameCategory(categoryDTO.getNameCategory());
        category.setTypeCategory(categoryDTO.getTypeCategory());
        return category;
    }
}
