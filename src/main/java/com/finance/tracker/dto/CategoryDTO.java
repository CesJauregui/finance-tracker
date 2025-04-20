package com.finance.tracker.dto;

public class CategoryDTO {

    private Long id;
    private String nameCategory;
    private String typeCategory;

    public CategoryDTO(Long id, String nameCategory, String typeCategory) {
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

    public String getTypeCategory() {
        return typeCategory;
    }

    public void setTypeCategory(String typeCategory) {
        this.typeCategory = typeCategory;
    }
}
