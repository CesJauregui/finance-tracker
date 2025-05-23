package com.finance.tracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.finance.tracker.enums.CategoryList;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoryList typeCategory;

    private Double amount;
    private String description;
    private String date;

    @JsonIgnoreProperties(value="transactions")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnoreProperties(value="transactions")
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Transaction() {
    }

    public Transaction(Long id, CategoryList typeCategory, Double amount, String description, String date, User user, Category category) {
        this.id = id;
        this.typeCategory = typeCategory;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.user = user;
        this.category = category;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
