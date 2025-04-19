package com.finance.tracker.mapper;

import com.finance.tracker.dto.AccountDTO;
import com.finance.tracker.entities.Account;

public class AccountMapper {
    public static AccountDTO toDTO(Account account){
        return new AccountDTO(account.getId(), account.getAccountName(), account.getAccountType(), account.getInitialBalance(), account.getCurrency(), account.getStatus(), account.getUser().getId());
    }

    public static Account toEntity(AccountDTO accountDTO){
        Account account = new Account();
        account.setId(accountDTO.getId());
        account.setAccountName(accountDTO.getAccountName());
        account.setAccountType(accountDTO.getAccountType());
        account.setInitialBalance(accountDTO.getInitialBalance());
        account.setCurrency(accountDTO.getCurrency());
        account.setStatus(accountDTO.getStatus());

        return account;
    }
}
