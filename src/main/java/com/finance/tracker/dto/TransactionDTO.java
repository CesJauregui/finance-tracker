package com.finance.tracker.dto;

import com.finance.tracker.enums.CategoryList;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;

public class TransactionDTO {
    private Long id;
    @Enumerated(EnumType.STRING)
    private CategoryList typeCategory;
    private Double amount;
    private String description;
    private String date;
    private Long userId;
    private Long categoryId;

    public TransactionDTO(Long id, CategoryList typeCategory, Double amount,
                          String description, String date, Long userId, Long categoryId) {
        this.id = id;
        this.typeCategory = typeCategory;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryList getTypeCategory() {
        return typeCategory;
    }

    public void setTypeCategory(CategoryList typeCategory) {
        this.typeCategory = typeCategory;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
