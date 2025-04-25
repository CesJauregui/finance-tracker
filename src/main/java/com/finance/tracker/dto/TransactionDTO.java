package com.finance.tracker.dto;

public class TransactionDTO {
    private Long id;
    private String typeCategory;
    private Double amount;
    private String description;
    private Long userId;
    private Long categoryId;

    public TransactionDTO(Long id, String typeCategory, Double amount,
                          String description, Long userId, Long categoryId) {
        this.id = id;
        this.typeCategory = typeCategory;
        this.amount = amount;
        this.description = description;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeCategory() {
        return typeCategory;
    }

    public void setTypeCategory(String typeCategory) {
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
}
