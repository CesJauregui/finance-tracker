package com.finance.tracker.services.impl;

import com.finance.tracker.dto.AccountDTO;
import com.finance.tracker.entities.Account;
import com.finance.tracker.entities.User;
import com.finance.tracker.mapper.AccountMapper;
import com.finance.tracker.repositories.AccountRepository;
import com.finance.tracker.repositories.UserRepository;
import com.finance.tracker.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<AccountDTO> getAll() {
        return accountRepository.findAll()
                .stream()
                .map(AccountMapper::toDTO)
                .toList();
    }

    @Override
    public AccountDTO getById(Long id) {
        return accountRepository.findById(id)
                .map(AccountMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("No se encontró la cuenta"));
    }

    @Override
    public AccountDTO createAccount(Long userId, AccountDTO account) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("No se encontró al usuario"));

        Account newAccount = new Account();
        newAccount.setId(account.getId());
        newAccount.setAccountName(account.getAccountName());
        newAccount.setAccountType(account.getAccountType());
        newAccount.setInitialBalance(account.getInitialBalance());
        newAccount.setCurrency(account.getCurrency());
        newAccount.setStatus(account.getStatus());
        newAccount.setUser(user);

        user.getAccounts().add(newAccount);

        return AccountMapper.toDTO(accountRepository.save(newAccount));
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
