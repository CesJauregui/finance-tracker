package com.finance.tracker.dto;

import com.finance.tracker.entities.User;

public class AccountDTO {
    private Long id;
    private String accountName;
    private String accountType;
    private Double initialBalance;
    private String currency;
    private Boolean status;
    private Long userId;
    public AccountDTO(Long id, String accountName, String accountType, Double initialBalance, String currency, Boolean status,Long userId) {
        this.id = id;
        this.accountName = accountName;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
        this.currency = currency;
        this.status = status;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(Double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
