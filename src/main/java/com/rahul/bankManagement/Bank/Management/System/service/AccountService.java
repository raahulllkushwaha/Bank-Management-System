package com.rahul.bankManagement.Bank.Management.System.service;

import com.rahul.bankManagement.Bank.Management.System.entity.Account;

import java.util.List;

public interface AccountService {
    public Account createAccount(Account account);
    public Account getAccountDetailsByAccountNum(Long accountNum);
    public List<Account> getAllAccountDetails();
    public Account depositAmount(Long accountNum, Double amount);
    public Account withdrawAmount(Long accountNum, Double amount);
    public void closeAccount(Long accountNum);
    public String transferAmount(Long fromAccountNum, Long toAccountNum, Double amount);
}
