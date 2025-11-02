package com.rahul.bankManagement.Bank.Management.System.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNum;
    @Column
    private String accountHolderName;
    @Column
    private double accountBal;

    public Account(){

    }

    public Account(String accountHolderName, double accountBal) {
        this.accountHolderName = accountHolderName;
        this.accountBal = accountBal;
    }

    public Long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Long accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getAccountBal() {
        return accountBal;
    }

    public void setAccountBal(double accountBal) {
        this.accountBal = accountBal;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNum=" + accountNum +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountBal=" + accountBal +
                '}';
    }
}
