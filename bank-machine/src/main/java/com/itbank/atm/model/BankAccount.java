package com.itbank.atm.model;

import java.util.Objects;

public abstract class BankAccount {
    private Integer balance;
    private String accountNumber;
    private String pinCode;

    public BankAccount() {

    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public BankAccount(Integer balance, String accountNumber, String pinCode) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(balance, that.balance) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(pinCode, that.pinCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, accountNumber, pinCode);
    }
}

