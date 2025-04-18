package com.finance.tracker.repositories;

import com.finance.tracker.entities.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
