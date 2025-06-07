package com.finance.tracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.finance.tracker.enums.CategoryList;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    @NotBlank
    private String nameCategory;

    @Enumerated(EnumType.STRING)
    @NotNull
    private CategoryList typeCategory;

    @JsonIgnoreProperties(value="category")
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @JsonIgnoreProperties(value="categories")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Category(){}

    public Category(Long id, String nameCategory, CategoryList typeCategory, List<Transaction> transactions, User user) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.typeCategory = typeCategory;
        this.transactions = transactions;
        this.user = user;
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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
