package com.rahul.bankManagement.Bank.Management.System.repo;

import com.rahul.bankManagement.Bank.Management.System.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
}
