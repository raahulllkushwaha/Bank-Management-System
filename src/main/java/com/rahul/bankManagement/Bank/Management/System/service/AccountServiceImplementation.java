package com.rahul.bankManagement.Bank.Management.System.service;

import com.rahul.bankManagement.Bank.Management.System.entity.Account;
import com.rahul.bankManagement.Bank.Management.System.repo.AccountRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImplementation implements AccountService {
    @Autowired
    AccountRepo repo;

    @Override
    public Account createAccount(Account account) {
        Account accountSaved = repo.save(account);
        return accountSaved;
    }

    @Override
    public Account getAccountDetailsByAccountNum(Long accountNum) {
        Optional<Account> account = repo.findById(accountNum);
        if (account.isEmpty()) {
            throw new RuntimeException("Account does not exist.");
        }
        Account accountFound = account.get();
        return accountFound;
    }


    @Override
    public List<Account> getAllAccountDetails() {
        List<Account> allAccountDetails = repo.findAll();
        return allAccountDetails;
    }

    @Override
    public Account depositAmount(Long accountNum, Double amount) {
        Optional<Account> account = repo.findById(accountNum);
        if (account.isEmpty()) {
            throw new RuntimeException("Account is not present");
        }
        Account accountPresent = account.get();
        Double totalBal = accountPresent.getAccountBal() + amount;
        accountPresent.setAccountBal(totalBal);
        repo.save(accountPresent);
        return accountPresent;
    }

    @Override
    public Account withdrawAmount(Long accountNum, Double amount) {
        Optional<Account> account = repo.findById(accountNum);
        if (account.isEmpty()) {
            throw new RuntimeException("Account is not present");
        }
        Account accountPresent = account.get();
        Double totalBal = accountPresent.getAccountBal() - amount;
        accountPresent.setAccountBal(totalBal);
        repo.save(accountPresent);
        return accountPresent;
    }


    @Override
    public void closeAccount(Long accountNum) {
        getAccountDetailsByAccountNum(accountNum);
        repo.deleteById(accountNum);
    }

    @Override
    @Transactional
    public String transferAmount(Long fromAccountNum, Long toAccountNum, Double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Amount must be greater than 0");
        }
        Optional<Account> fromAccount = repo.findById(fromAccountNum);
        if (fromAccount.isEmpty()) {
            throw new RuntimeException("Source Account does not exist.");
        }

        Optional<Account> toAccount = repo.findById(toAccountNum);
        if (toAccount.isEmpty()) {
            throw new RuntimeException("Destination Account does not exist.");
        }

        Account sourceAccount = fromAccount.get();
        Account destinationAccount = toAccount.get();

        if(sourceAccount.getAccountBal() < amount){
            throw new RuntimeException("Insufficient balance in source account..!!");
        }

        sourceAccount.setAccountBal(sourceAccount.getAccountBal() - amount);
        destinationAccount.setAccountBal(destinationAccount.getAccountBal() + amount);

        repo.save(sourceAccount);
        repo.save(destinationAccount);

        return "Transfer successful! Amount: " + amount +
                " transferred from Account " + fromAccountNum +
                " to Account " + toAccountNum;
    }
}
