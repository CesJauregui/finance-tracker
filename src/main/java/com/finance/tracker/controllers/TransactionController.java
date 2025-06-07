package com.finance.tracker.controllers;

import com.finance.tracker.dto.SummaryResponseDTO;
import com.finance.tracker.dto.TransactionDTO;
import com.finance.tracker.entities.User;
import com.finance.tracker.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping
    public ResponseEntity<?> getTransactions(@AuthenticationPrincipal User user){
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.getTransactionByUser(user));
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

    @GetMapping("/summary")
    public SummaryResponseDTO getSummary(@AuthenticationPrincipal User user){
        return transactionService.getTotalByCategory(user);
    }
}
