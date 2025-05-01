package com.finance.tracker.repositories;

import com.finance.tracker.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value = "SELECT t.type_category, SUM(t.amount) FROM transactions t GROUP BY t.type_category", nativeQuery = true)
    List<Object[]> getTotalByCategoryTransaction();

    @Query(value = "SELECT (SELECT SUM(b.amount) FROM transactions b WHERE b.type_category = 'INGRESO') - \n" +
            "(SELECT SUM(c.amount) FROM transactions c WHERE c.type_category = 'GASTO') AS RESTA;", nativeQuery = true)
    Double getTotal();
}
