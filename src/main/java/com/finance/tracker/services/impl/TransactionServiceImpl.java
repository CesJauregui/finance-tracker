package com.finance.tracker.services.impl;

import com.finance.tracker.dto.TransactionDTO;
import com.finance.tracker.entities.Category;
import com.finance.tracker.entities.Transaction;
import com.finance.tracker.entities.User;
import com.finance.tracker.mapper.TransactionMapper;
import com.finance.tracker.repositories.CategoryRepository;
import com.finance.tracker.repositories.TransactionRepository;
import com.finance.tracker.repositories.UserRepository;
import com.finance.tracker.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public TransactionDTO getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .map(TransactionMapper::toDTO)
                .orElseThrow(()->new RuntimeException("No se encontró la transacción"));
    }

    @Override
    public TransactionDTO createTransaction(TransactionDTO transaction) {
        System.out.println("CategoryId recibido: " + transaction.getCategoryId());
        Transaction newTransaction = new Transaction();
        newTransaction.setTypeCategory(transaction.getTypeCategory());
        newTransaction.setAmount(transaction.getAmount());
        newTransaction.setDescription(transaction.getDescription());
        newTransaction.setDate(transaction.getDate());

        Category category = categoryRepository.findById(transaction.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        newTransaction.setCategory(category);

        User user = userRepository.findById(transaction.getUserId())
                .orElseThrow(()-> new RuntimeException("No se encontró al usuario"));
        newTransaction.setUser(user);

        return TransactionMapper.toDTO(transactionRepository.save(newTransaction));
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
