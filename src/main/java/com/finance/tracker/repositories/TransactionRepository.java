package com.finance.tracker.repositories;

import com.finance.tracker.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value = "SELECT t.type_category, SUM(t.amount) FROM transactions t WHERE t.user_id = :userId \n" +
            "GROUP BY t.type_category", nativeQuery = true)
    List<Object[]> getTotalByCategoryTransaction(@Param("userId") Long userId);

    @Query(value = "SELECT (SELECT SUM(b.amount) FROM transactions b WHERE b.type_category = 'INGRESO' AND b.user_id = :userId) - \n" +
            "(SELECT SUM(c.amount) FROM transactions c WHERE c.type_category = 'GASTO' AND c.user_id = :userId) AS RESTA;", nativeQuery = true)
    Double getTotal(@Param("userId") Long userId);

    @Query("SELECT t FROM Transaction t WHERE t.user.username = :username ORDER BY t.createdAt DESC")
    List<Transaction> findByUsername(@Param("username") String username);
}
