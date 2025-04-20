package com.finance.tracker.controllers;

import com.finance.tracker.dto.AccountDTO;
import com.finance.tracker.dto.UserDTO;
import com.finance.tracker.entities.Account;
import com.finance.tracker.entities.User;
import com.finance.tracker.services.AccountService;
import com.finance.tracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> getAccounts(){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.getById(id));
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<AccountDTO> postAccount(@RequestBody AccountDTO account, @PathVariable Long userId){
        AccountDTO accountDTO = accountService.createAccount(userId, account);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(accountDTO.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
