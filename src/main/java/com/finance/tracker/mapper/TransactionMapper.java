package com.finance.tracker.mapper;

import com.finance.tracker.dto.TransactionDTO;
import com.finance.tracker.entities.Transaction;

public class TransactionMapper {
    public static TransactionDTO toDTO(Transaction transaction){
        return new TransactionDTO(transaction.getId(), transaction.getTypeCategory(), transaction.getAmount(),
                transaction.getDescription(), transaction.getDate(), transaction.getUser().getId(), transaction.getCategory().getId());
    }

    public static Transaction toEntity(TransactionDTO transactionDTO){
        Transaction transaction = new Transaction();
        transaction.setId(transactionDTO.getId());
        transaction.setTypeCategory(transactionDTO.getTypeCategory());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setDescription(transactionDTO.getDescription());
        transaction.setDate(transactionDTO.getDate());

        return transaction;
    }
}
