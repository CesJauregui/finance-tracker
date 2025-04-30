package com.finance.tracker.controllers;

import com.finance.tracker.dto.TransactionDTO;
import com.finance.tracker.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping
    public ResponseEntity<?> getTransactions(){
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.getAll());
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionDTO transaction){

        try {
            transactionService.createTransaction(transaction);

            return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
