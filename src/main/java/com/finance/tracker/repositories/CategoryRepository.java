package com.finance.tracker.repositories;

import com.finance.tracker.entities.Category;
import com.finance.tracker.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<String> findByTypeCategory(String type);

    @Query("SELECT t FROM Category t WHERE t.user.username = :username")
    List<Category> findByUsername(@Param("username") String username);
}
