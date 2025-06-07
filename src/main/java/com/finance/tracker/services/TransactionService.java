package com.finance.tracker.services;

import com.finance.tracker.dto.SummaryResponseDTO;
import com.finance.tracker.dto.TransactionDTO;
import com.finance.tracker.entities.Transaction;
import com.finance.tracker.entities.User;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAll();
    TransactionDTO getTransactionById(Long id);
    TransactionDTO createTransaction(TransactionDTO transactionDTO);
    void deleteTransaction(Long id);
    SummaryResponseDTO getTotalByCategory(User user);
    List<TransactionDTO> getTransactionByUser(User user);
}
