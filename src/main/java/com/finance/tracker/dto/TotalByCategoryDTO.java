package com.finance.tracker.dto;

public class TotalByCategoryDTO {
    private String categoryType;
    private Double total;

    public TotalByCategoryDTO(String categoryType, Double total) {
        this.categoryType = categoryType;
        this.total = total;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
