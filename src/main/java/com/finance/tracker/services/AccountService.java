package com.finance.tracker.services;

import com.finance.tracker.dto.AccountDTO;
import com.finance.tracker.entities.Account;

import java.util.List;

public interface AccountService {
    List<AccountDTO> getAll();
    AccountDTO getById(Long id);
    AccountDTO createAccount(Long userId, AccountDTO account);
    void deleteAccount(Long id);
}
