package com.finance.tracker.dto;

import com.finance.tracker.enums.CategoryList;

public class CategoryDTO {

    private Long id;
    private String nameCategory;
    private CategoryList typeCategory;

    public CategoryDTO(Long id, String nameCategory, CategoryList typeCategory) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.typeCategory = typeCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public CategoryList getTypeCategory() {
        return typeCategory;
    }

    public void setTypeCategory(CategoryList typeCategory) {
        this.typeCategory = typeCategory;
    }
}
