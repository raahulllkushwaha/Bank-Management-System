package com.rahul.bankManagement.Bank.Management.System.controller;

import com.rahul.bankManagement.Bank.Management.System.entity.Account;
import com.rahul.bankManagement.Bank.Management.System.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService service;
    //Create the account
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
       Account createAccount = service.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
    }

    @GetMapping("/{accountNum}")
    public Account getAllAccountDetails(@PathVariable Long accountNum){
        Account account = service.getAccountDetailsByAccountNum(accountNum);
        return account;
    }
}
