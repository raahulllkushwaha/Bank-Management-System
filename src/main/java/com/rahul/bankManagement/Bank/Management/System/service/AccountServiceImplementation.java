package com.rahul.bankManagement.Bank.Management.System.service;

import com.rahul.bankManagement.Bank.Management.System.entity.Account;
import com.rahul.bankManagement.Bank.Management.System.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImplementation implements AccountService{
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
            if(account.isEmpty()){
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
        if(account.isEmpty()){
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
        return null;
    }

    @Override
    public void closeAccount(Long accountNum) {

    }
}
